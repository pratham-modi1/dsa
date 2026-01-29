// ==================
// CANVAS SETUP
// ==================
const canvas = document.getElementById("game");
const ctx = canvas.getContext("2d");

function resize() {
  canvas.width = window.innerWidth;
  canvas.height = window.innerHeight;
}
resize();
window.addEventListener("resize", resize);

// ==================
// GAME CONSTANTS
// ==================
const LANES = [-1, 0, 1];
const LANE_WIDTH = 120;
const FORWARD_SPEED = 12;
const SPAWN_INTERVAL = 900;

// ==================
// GAME STATE
// ==================
let gameState = "RUNNING";

// ==================
// PLAYER STATE
// ==================
const player = {
  lane: 0,
  targetLane: 0,
  x: () => canvas.width / 2 + player.lane * LANE_WIDTH,
  y: () => canvas.height * 0.7,
  size: 40,
  moveSpeed: 0.25
};

// ==================
// INPUT STATE
// ==================
let lastKey = null;
let lastKeyTime = 0;
const DOUBLE_TAP_TIME = 250;

// ==================
// OBSTACLES
// ==================
let obstacles = [];
let lastSpawnTime = 0;

// ==================
// SCREEN SHAKE
// ==================
let shakeTime = 0;
let shakeIntensity = 12;

function triggerShake(ms = 300) {
  shakeTime = ms;
}

// ==================
// AUDIO
// ==================
const hitSounds = [
  new Audio("audio/aandarai.mp3"),
  new Audio("meme.mp3")
];

const bgm = new Audio("bgm.mp3");
bgm.loop = true;
bgm.volume = 0.35;
let bgmStarted = false;

// ==================
// GORILLA IMAGE
// ==================
const gorillaImg = new Image();
gorillaImg.src = "gorilla.png";
let gorillaImgLoaded = false;

gorillaImg.onload = () => {
  gorillaImgLoaded = true;
};

// ==================
// GORILLA PRESSURE
// ==================
let gorillaDistance = 100;
let hitCount = 0;
let lastHitTime = 0;
const HIT_WINDOW = 60000;

// ==================
// SUMMON EDY
// ==================
let edyUsed = false;
let edyActive = false;
let edyEndTime = 0;
const EDY_DURATION = 5000;

// ==================
// ROAD VISUALS
// ==================
let roadOffset = 0;

// ==================
// INPUT
// ==================
window.addEventListener("keydown", (e) => {
  if (!bgmStarted) {
    bgm.play();
    bgmStarted = true;
  }

  if (gameState !== "RUNNING") return;
  if (e.repeat) return;

  if (e.code === "Space") {
    summonEdy();
    return;
  }

  if (e.key === "ArrowLeft" || e.key === "ArrowRight") {
    handleArrow(e.key);
  }
});

function handleArrow(key) {
  const now = performance.now();
  if (key === lastKey && now - lastKeyTime < DOUBLE_TAP_TIME) {
    player.targetLane = key === "ArrowLeft" ? -1 : 1;
  } else {
    player.targetLane += key === "ArrowLeft" ? -1 : 1;
    player.targetLane = Math.max(-1, Math.min(1, player.targetLane));
  }
  lastKey = key;
  lastKeyTime = now;
}

// ==================
// SUMMON EDY
// ==================
function summonEdy() {
  if (edyUsed) return;
  edyUsed = true;
  edyActive = true;
  edyEndTime = performance.now() + EDY_DURATION;
}

// ==================
// OBSTACLES
// ==================
function spawnObstacle() {
  obstacles.push({
    lane: LANES[Math.floor(Math.random() * 3)],
    y: -60,
    size: 35,
    hit: false
  });
}

// ==================
// HIT LOGIC
// ==================
function registerHit() {
  const now = performance.now();
  if (now - lastHitTime > HIT_WINDOW) hitCount = 0;

  hitCount++;
  lastHitTime = now;
  gorillaDistance -= 35;

  if (hitCount >= 3 || gorillaDistance <= 0) {
    gameState = "LOST";
    bgm.pause();
  }
}

// ==================
// UPDATE
// ==================
function update() {
  if (gameState !== "RUNNING") return;

  if (edyActive && performance.now() > edyEndTime) {
    edyActive = false;
  }

  player.lane += (player.targetLane - player.lane) * player.moveSpeed;

  // Road movement
  if (!edyActive) {
    roadOffset += FORWARD_SPEED;
    roadOffset %= 40;
  }

  // Spawn obstacles
  const now = performance.now();
  if (!edyActive && now - lastSpawnTime > SPAWN_INTERVAL) {
    spawnObstacle();
    lastSpawnTime = now;
  }

  // Move obstacles
  if (!edyActive) {
    obstacles.forEach(o => o.y += FORWARD_SPEED);
  }

  obstacles = obstacles.filter(o => o.y < canvas.height + 100);

  // Collision
  if (!edyActive) {
    obstacles.forEach(o => {
      if (o.hit) return;
      const sameLane = Math.round(player.lane) === o.lane;
      const close = Math.abs(o.y - player.y()) < o.size + player.size;
      if (sameLane && close) {
        o.hit = true;
        hitSounds[Math.floor(Math.random() * hitSounds.length)].play();
        triggerShake();
        registerHit();
      }
    });
  }
}

// ==================
// DRAW ROAD
// ==================
function drawRoad() {
  const roadWidth = LANE_WIDTH * 3;
  const roadX = canvas.width / 2 - roadWidth / 2;

  ctx.fillStyle = "#222";
  ctx.fillRect(roadX, 0, roadWidth, canvas.height);

  ctx.strokeStyle = "#555";
  ctx.lineWidth = 4;

  for (let i = -40; i < canvas.height; i += 40) {
    const y = i + roadOffset;
    ctx.beginPath();
    ctx.moveTo(canvas.width / 2, y);
    ctx.lineTo(canvas.width / 2, y + 20);
    ctx.stroke();
  }
}

// ==================
// DRAW GORILLAS (IMAGE VERSION)
// ==================
function drawGorillas() {
  const closeness = 1 - gorillaDistance / 100; // 0 → far, 1 → caught

  // scale & position based on pressure
  const baseSize = 140 + closeness * 120;
  const y =
    player.y() + 120 - closeness * 90;

  for (let i = -1; i <= 1; i++) {
    const x =
      canvas.width / 2 + i * 120 - baseSize / 2;

    if (gorillaImgLoaded) {
      ctx.drawImage(
        gorillaImg,
        x,
        y - baseSize / 2,
        baseSize,
        baseSize
      );
    } else {
      // fallback (never invisible)
      ctx.fillStyle = "#000";
      ctx.beginPath();
      ctx.arc(
        canvas.width / 2 + i * 120,
        y,
        baseSize / 3,
        0,
        Math.PI * 2
      );
      ctx.fill();
    }
  }
}


// ==================
// RENDER
// ==================
function render() {
  ctx.save();

  if (shakeTime > 0) {
    ctx.translate(
      (Math.random() - 0.5) * shakeIntensity,
      (Math.random() - 0.5) * shakeIntensity
    );
    shakeTime -= 16;
  }

  ctx.clearRect(0, 0, canvas.width, canvas.height);

  drawRoad();
  drawGorillas();

  // Obstacles
  ctx.fillStyle = "#c00";
  obstacles.forEach(o => {
    const x = canvas.width / 2 + o.lane * LANE_WIDTH;
    ctx.fillRect(x - o.size, o.y - o.size, o.size * 2, o.size * 2);
  });

  // Player
  ctx.fillStyle = "#0f0";
  ctx.beginPath();
  ctx.arc(player.x(), player.y(), player.size, 0, Math.PI * 2);
  ctx.fill();

  ctx.restore();

  // UI
  ctx.fillStyle = "#fff";
  ctx.font = "14px monospace";
  ctx.fillText(`HITS: ${hitCount}/3`, 20, 30);

  ctx.fillStyle = "#555";
  ctx.fillRect(20, 45, 200, 12);
  ctx.fillStyle = "#f00";
  ctx.fillRect(20, 45, Math.max(gorillaDistance * 2, 0), 12);

  if (edyActive) {
    ctx.font = "28px monospace";
    ctx.textAlign = "center";
    ctx.fillText("INVESTIGATION ONGOING", canvas.width / 2, 120);
    ctx.textAlign = "left";
  }

  if (gameState === "LOST") {
    ctx.font = "48px monospace";
    ctx.textAlign = "center";
    ctx.fillText("YOU WERE CAUGHT", canvas.width / 2, canvas.height / 2);
    ctx.textAlign = "left";
  }
}

// ==================
// LOOP
// ==================
function loop() {
  update();
  render();
  requestAnimationFrame(loop);
}

loop();
