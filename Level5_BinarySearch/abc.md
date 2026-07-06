# Fintech: Complete Guide (0 → 100)
*Built for FinSpark'26 — read once fully, then use as reference during the hackathon.*

---

## HOW TO USE THIS DOC
Read Parts 1–6 top to bottom once (2-3 hrs). Parts 7-9 are reference — come back to them when you hit a term in your PS you don't know. Part 10 is specifically mapped to PS2 (your track).

---

# PART 1: BANKING FOUNDATIONS

## 1.1 What a bank actually is
A bank is a licensed institution that does 3 things simultaneously:
1. **Custodian** — holds your money safely (deposits)
2. **Lender** — lends that money out to others (loans)
3. **Rails operator** — moves money between people/accounts (payments)

It's regulated because it's playing with other people's money — that's why every fintech problem eventually touches "compliance" or "risk."

**Key insight for hackathons:** your bank balance is not "cash sitting somewhere." It's a *ledger entry* — a number in a database that the bank owes you. This is why "ledger accuracy" and "reconciliation" are recurring PS themes — if the ledger is wrong, real money is wrong.

## 1.2 Account types
| Term | Meaning | Example |
|---|---|---|
| Savings account | Personal account, earns interest, limited transactions/month | Your salary account |
| Current account | Business account, no interest, unlimited transactions | A shopkeeper's account |
| Fixed Deposit (FD) | Lock money for X months/years, get higher fixed interest | ₹1L locked for 1yr at 7% |
| Recurring Deposit (RD) | Deposit fixed amount monthly, earns interest | ₹2000/month for 2 years |
| Wallet | Non-bank stored balance (semi-closed/closed) | Paytm wallet balance |

**Balance vs Available Balance:** Balance = total money in account. Available balance = balance minus holds (e.g., a pending card authorization). PS statements about "wrong balance shown" usually hinge on this gap.

## 1.3 Cards — debit, credit, prepaid
- **Debit card:** spends directly from your account balance. No borrowing.
- **Credit card:** bank lends you money now, you repay later (with interest if late). This is literally a tiny unsecured loan every time you swipe.
- **Prepaid card:** you load money first (like a wallet card), then spend from that loaded balance only.

**Players in a card transaction:**
- **Issuer bank** — gave you the card (e.g., HDFC issued your Visa card)
- **Acquirer bank** — banks the merchant, receives the payment on merchant's behalf
- **Card network** — Visa/Mastercard/RuPay — the rail connecting issuer ↔ acquirer
- **Merchant** — the shop/website

Example flow: You tap card at a café →
café's POS (acquirer's system) → card network → your bank (issuer) checks balance/fraud → approves → money settles later (T+1 or T+2 days) → café gets paid minus a small **interchange fee**.

## 1.4 Loans & EMI
- **Principal:** the amount borrowed.
- **Interest:** cost of borrowing, usually annual % (APR).
- **EMI (Equal Monthly Installment):** fixed monthly payment = part principal + part interest. Early EMIs are interest-heavy, later ones are principal-heavy (amortization).
- **Collateral:** asset pledged as security (house for home loan). No collateral = "unsecured loan" = higher interest (personal loans, credit cards).
- **Overdraft (OD):** spend more than your balance up to a pre-approved limit, pay interest only on the overdrawn amount.

## 1.5 Bank's internal teams (useful when a PS mentions "a bank wants to...")
- **Operations** — account opening, KYC, handling failed transactions
- **Risk** — decides who gets a loan, what credit limit, flags suspicious behavior
- **Compliance/Legal** — enforces RBI/regulatory rules, AML, KYC norms
- **Treasury** — manages the bank's own liquidity and interest rate exposure
- **Collections** — recovers overdue loans/cards
- **Technology** — builds the apps, APIs, internal fraud/risk engines

---

# PART 2: PAYMENTS — HOW MONEY ACTUALLY MOVES

This is the single biggest chunk of fintech. Master this and 50% of any fintech PS becomes readable.

## 2.1 Payment rails (India-specific, since FinSpark is India-based)
| Rail | Speed | Use case | Example |
|---|---|---|---|
| UPI | Instant, 24x7 | Person-to-person, small merchant payments | Paying ₹150 to a chaiwala via QR |
| IMPS | Instant, 24x7 | Bank-to-bank transfer, needs account+IFSC | Sending money to a friend's account |
| NEFT | Batches (near-instant now) | Bulk/scheduled transfers | Salary credit |
| RTGS | Instant, for large amounts (₹2L+) | High-value transfers | Business paying a vendor ₹10L |
| Card networks | Instant auth, delayed settlement | Card swipe/online payment | Amazon checkout |

## 2.2 The full lifecycle of one transaction
Every payment—UPI, card, netbanking—goes through roughly these stages. Memorize this; almost every PS is about breaking, fixing, or optimizing one of these stages.

1. **Initiation** — user hits "pay"
2. **Authorization** — checking if the payment CAN happen right now (enough balance? card not blocked? not fraud?)
3. **Capture** — finalizing that authorized payment
4. **Clearing** — banks exchange transaction info
5. **Settlement** — actual money moves between banks (this can be delayed — T+1, T+2)
6. **Reconciliation** — everyone checks their records match (did merchant get paid what customer paid?)

If any stage fails partway (e.g., money debited from customer but not credited to merchant), you get a **"stuck" or "pending" transaction** — one of the most common real-world fintech pain points and hackathon PS topics.

## 2.3 Key payment infrastructure terms
- **Payment Gateway:** software that captures payment details securely and routes them (e.g., Razorpay's checkout widget on a website).
- **Payment Processor:** the engine that actually processes the transaction with banks/networks behind the scenes.
- **Payment Aggregator:** lets a merchant accept UPI+cards+wallets+netbanking through ONE integration instead of 10 (Razorpay, Cashfree, PayU do this).
- **PSP (Payment Service Provider):** the entity(bank/fintech) that provides the actual UPI handle/infra (e.g., "@ybl" is PSP handle of Yes Bank via PhonePe).
- **Settlement:** the real transfer of funds between institutions, which is separate (and later) from the customer-facing "payment success."
- **Refund vs Reversal vs Chargeback:**
  - *Refund* = merchant voluntarily returns money
  - *Reversal* = a failed transaction gets auto-undone
  - *Chargeback* = customer disputes with their bank/card network, and the bank forcibly pulls money back from merchant
- **Tokenization:** replacing your actual card number with a random "token" for storage, so merchants never store real card numbers (RBI mandated this in India — big real compliance topic).
- **Idempotency:** ensuring if the same payment request is sent twice (e.g., due to network retry), the customer isn't charged twice. Massive real-world engineering problem — often shows up in PS as "duplicate transaction" issues.
- **Webhook:** a callback — e.g., a payment gateway "pings" the merchant's server saying "hey, this payment just succeeded/failed."

## 2.4 Worked Example: Full UPI Payment
You scan a QR and pay ₹500 to a shop.
1. Your UPI app sends request with UPI PIN to your bank (via NPCI's UPI switch).
2. NPCI routes request to your bank → checks balance/fraud rules → approves.
3. NPCI routes confirmation to shop's bank.
4. Both banks update their ledgers ("debit ₹500 from you," "credit ₹500 to shop" minus MDR if any).
5. Settlement between banks happens in the background (batch, later).
6. If anything fails mid-way → money debited but not credited → this becomes a "failed but debited" case, resolved via **auto-reversal within T+1 day** (RBI mandated).

---

# PART 3: LENDING & CREDIT

## 3.1 The loan lifecycle
Application → Underwriting → Sanction (approval) → Disbursement → Repayment → Closure (or Default)

## 3.2 Key terms
- **Credit score:** a number (300-900 in India, via CIBIL/Experian/Equifax) predicting repayment reliability, based on past credit history.
- **Credit bureau:** company that maintains this score/history (CIBIL is the biggest in India).
- **Underwriting:** the process/algorithm deciding "should we lend, and how much, at what interest?" — This is THE core ML problem in most lending fintechs.
- **Sanction:** loan officially approved.
- **Disbursement:** money actually released to borrower.
- **Delinquency:** payment overdue but not yet written off.
- **Default:** borrower stops repaying — loan effectively lost unless recovered.
- **NPA (Non-Performing Asset):** a loan where payment hasn't been made for 90+ days — banks must set aside extra capital for these; huge regulatory/financial concern.
- **Collections:** the process (calls, reminders, legal notices, agents) of recovering overdue money.
- **BNPL (Buy Now Pay Later):** short-term, often 0-interest-if-paid-on-time credit at point of purchase (Simpl, LazyPay, ZestMoney-style).
- **Alternative data underwriting:** using non-traditional data (UPI transaction history, utility bill payments, phone usage) to score people with no formal credit history — big fintech innovation area, especially for India's underbanked population.

## 3.3 Example
A gig worker with no credit history applies for a ₹10,000 loan on an app. Instead of a credit bureau score, the app's ML model looks at his UPI transaction patterns (regular income, spending discipline) to decide creditworthiness → approves a small loan at higher interest to offset risk → disburses instantly → auto-deducts EMI from his UPI-linked account monthly.

---

# PART 4: KYC, AML, FRAUD & COMPLIANCE (the domain closest to your PS)

## 4.1 KYC (Know Your Customer)
Verifying WHO a customer actually is before letting them transact — required by law.
- **Documents used:** Aadhaar, PAN, passport, etc.
- **e-KYC:** digital/instant verification (Aadhaar OTP-based)
- **Video KYC:** live video call verification
- **Why it matters in PS:** "faster onboarding" problem statements = making KYC frictionless while staying compliant.

## 4.2 AML (Anti-Money Laundering)
Rules & systems to detect money being "cleaned" through legitimate-looking transactions (drug money, corruption proceeds, terror financing routed through fake businesses).
- **Structuring/Smurfing:** breaking a large illegal amount into many small transactions to avoid detection thresholds — a classic AML pattern-detection problem.
- **STR (Suspicious Transaction Report):** report banks/fintechs must file with the regulator (FIU-IND in India) when they detect suspicious activity.
- **Transaction Monitoring System (TMS):** software that watches transactions in real time/batch for suspicious rule-based or ML-based patterns.

## 4.3 Fraud types (VERY relevant to your PS2)
| Fraud type | What it is | Example |
|---|---|---|
| Account takeover (ATO) | Attacker gains access to a legit user's account | Phished OTP used to log in and drain wallet |
| Phishing | Fake message/site tricking user into giving credentials | Fake "bank" SMS with a login link |
| SIM swap fraud | Attacker gets victim's number ported to a new SIM to intercept OTPs | Used to bypass 2FA and empty bank account |
| Card skimming | Copying card data via a tampered ATM/POS device | Cloned card used for fraud txns elsewhere |
| Synthetic identity fraud | Fake identity built from real+fake data to open accounts/get credit | Used to take loans with no intention to repay |
| Money mule accounts | Accounts used to receive and quickly move stolen/laundered money | Multiple small deposits from different victims, quickly withdrawn |
| Transaction fraud (velocity) | Abnormally fast/frequent transactions from one account | 20 transactions in 2 minutes from a normally-quiet account |
| First-party fraud | Genuine customer intentionally defaults/disputes a legit charge | User claims "I didn't make this purchase" falsely for a refund |

## 4.4 How fraud/risk systems actually work (core to your PS)
- **Rule-based engine:** hardcoded logic ("flag if transaction > ₹50,000 AND new device AND odd hour"). Fast, explainable, but rigid — fraudsters learn to dodge known rules.
- **ML-based anomaly detection:** model learns "normal" behavior per user/segment and flags deviations. Better at catching novel fraud, but needs data and is less explainable ("black box" problem — important for regulated domains!).
- **Hybrid approach (most real systems):** rules catch known patterns instantly; ML scores everything and flags edge cases for review. This is usually what a strong hackathon solution proposes.
- **Feature engineering for fraud/risk models — the actual signals used:**
  - transaction velocity (txns per minute/hour)
  - amount deviation from user's historical average
  - device fingerprint change
  - geolocation jump (impossible travel — logged in Mumbai, transacting from Delhi 2 mins later)
  - time-of-day anomaly
  - new payee/beneficiary added just before a large transfer
  - network graph features (is this account connected to other flagged accounts?)
- **False positive vs false negative trade-off:** flag too aggressively → annoy genuine customers (bad UX, lost trust). Flag too loosely → real fraud slips through. Every fraud system design must explicitly address this trade-off — **judges will expect you to mention it.**
- **Explainability (XAI):** in regulated fintech, you usually can't just say "the model said so" — you need to explain WHY a transaction was flagged (e.g., using SHAP values) for compliance/audit and for the human reviewer.

## 4.5 Cybersecurity ↔ Transactional correlation (this is literally your PS)
Your PS2 title: "AI-Driven Correlation of Cybersecurity Telemetry and Transactional Behaviour" means:
- **Cybersecurity telemetry** = logs/signals from IT security systems: failed login attempts, device fingerprint changes, IP/geolocation anomalies, malware alerts, endpoint security logs, network intrusion alerts, VPN/proxy usage detection.
- **Transactional behaviour** = the banking-side signals: transaction amount, frequency, beneficiary patterns, time-of-day, channel used (UPI/card/netbanking).
- **The correlation problem:** today, cybersecurity teams and fraud/risk teams often work in silos with separate systems. A hacker who breaches an account (cyber event) then makes fraudulent transactions (transactional event) — if these two data streams aren't correlated, the fraud can slip through because each system alone might see "normal-ish" activity.
- **What a good solution looks like:** a unified engine that ingests BOTH telemetry streams, builds a joint risk score, and flags/blocks transactions when a security anomaly (e.g., new device + odd location) coincides with an unusual transaction (e.g., large transfer to a new payee) — catching attacks that neither signal alone would confidently flag.
- **Real example:** A user's login happens from a new IP in another country (cyber signal) at 3 AM, immediately followed by a large fund transfer to a never-used beneficiary (transactional signal). Individually, foreign IP logins happen (VPN users) and large transfers happen (salary, rent) — but the *correlation* of both, close in time, is a strong fraud signal.

---

# PART 5: WEALTH, INSURANCE & OTHER FINTECH VERTICALS (breadth, for judging panel context)

## 5.1 Wealthtech (investing apps)
- **NAV (Net Asset Value):** price per unit of a mutual fund.
- **SIP (Systematic Investment Plan):** fixed amount invested regularly (monthly).
- **Portfolio:** collection of a user's investments.
- **Robo-advisor:** algorithm-driven investment recommendation (based on risk profile, goals).
- **Brokerage:** platform/fee for buying/selling stocks (Zerodha, Groww).
- Example: Groww lets you invest ₹500/month via SIP into a mutual fund — Groww is the interface; the actual fund is run by an AMC (Asset Management Company) like SBI Mutual Fund.

## 5.2 Insurtech
- **Premium:** amount paid regularly for insurance coverage.
- **Claim:** request for payout when the insured event happens.
- **Underwriting (insurance):** deciding premium based on risk (age, health, driving record).
- **Deductible:** amount the insured pays out-of-pocket before insurance kicks in.
- Example: Digit Insurance lets you buy car insurance in 2 minutes and file a claim by uploading photos of damage, using computer vision to auto-assess damage cost.

## 5.3 Regtech
Technology purely for compliance — automated KYC checks, automated regulatory reporting, real-time AML monitoring. Example: a regtech tool that auto-generates the suspicious transaction reports (STRs) banks must file.

## 5.4 Business models to know
- **BaaS (Banking as a Service):** a fintech uses a licensed bank's infrastructure via APIs to offer banking features without becoming a bank itself. Example: a neobank like Jupiter/Fi doesn't have a banking license — it partners with a real bank (Federal Bank) behind the scenes.
- **Embedded finance:** financial services baked into a non-financial app. Example: Ola/Uber offering an in-app wallet, or Amazon offering "Pay Later" at checkout.
- **Neobank:** a digital-only bank-like experience (app, cards, spending insights) built on top of a partner bank's license.
- **Interchange/MDR (Merchant Discount Rate):** the small fee (%) charged to merchants for accepting digital payments — a major revenue line for payment companies.
- **Take rate:** % of transaction value a platform keeps as revenue.

---

# PART 6: SYSTEM/ENGINEERING TERMS THAT SHOW UP IN FINTECH PS

- **Ledger:** the authoritative record of who owns/owes what money. In software, often an immutable, append-only log (never edit history, only add correcting entries) — critical for auditability.
- **Double-entry accounting (in software):** every transaction is recorded as a debit in one account and a credit in another, so the books always "balance." Prevents money from silently appearing/disappearing due to bugs.
- **Idempotency key:** a unique ID attached to a request so retries don't cause duplicate processing.
- **Eventual consistency vs strong consistency:** in distributed systems, sometimes all parts of the system don't update instantly (eventual) vs. must always be perfectly in sync (strong) — money movement usually needs strong consistency at the ledger level.
- **Audit trail:** an immutable log of every action taken, by whom, when — mandatory in regulated fintech for investigations/compliance.
- **Rate limiting:** capping how many requests/transactions a user or system can make in a time window — used both for system stability and fraud prevention (e.g., block if 50 login attempts in 1 minute).
- **Anomaly detection / outlier detection:** ML techniques (isolation forest, autoencoders, clustering) used to spot data points that don't fit the normal pattern — core to fraud detection.
- **Graph-based fraud detection:** modeling accounts/transactions as a network graph to detect fraud rings (multiple accounts linked by shared devices/IPs/beneficiaries) that look innocent individually but suspicious as a connected cluster.
- **Real-time vs batch processing:** fraud detection ideally happens real-time (before a transaction completes) vs batch (after, e.g. nightly AML scans). Real-time is harder but far more valuable — mention this trade-off in your solution.

---

# PART 7: QUICK-FIRE GLOSSARY (for when you just need a 1-line definition mid-hackathon)

- **APR:** Annual Percentage Rate — yearly cost of borrowing including fees.
- **CIBIL score:** India's most common credit score (300-900).
- **UPI ID/VPA:** Virtual Payment Address, e.g. `pratham@okhdfcbank`.
- **IFSC code:** unique code identifying a bank branch for transfers.
- **OTP:** One-Time Password, a common 2FA mechanism (also a common fraud target via phishing/SIM-swap).
- **2FA/MFA:** Two/Multi-Factor Authentication.
- **PCI-DSS:** global security standard for handling card data.
- **RBI:** Reserve Bank of India — the regulator for banks/payments/lending in India.
- **NPCI:** National Payments Corporation of India — runs UPI, IMPS, RuPay.
- **SEBI:** regulator for stock markets/investments in India.
- **IRDAI:** regulator for insurance in India.
- **Sandbox:** a regulator-approved safe environment fintechs can test new products in with real (limited) users before full launch.
- **API:** how fintech systems talk to banks/bureaus/each other (e.g., calling a credit bureau's API to pull a score).
- **Webhook:** async notification from one system to another when an event happens.
- **Latency:** time taken for a system to respond — critical in payments (nobody wants a 10-second UPI confirmation).
- **Uptime/SLA:** how reliably a system is available — critical since payment downtime = lost transactions = lost trust.

---

# PART 8: REAL COMPANIES BY CATEGORY (so you can name-drop credibly)

| Category | Companies | What they actually do |
|---|---|---|
| UPI/Payments apps | PhonePe, Google Pay, Paytm | Customer-facing payment apps |
| Payment infra/gateway | Razorpay, Cashfree, PayU, CCAvenue | Let merchants accept payments |
| Lending | KreditBee, MoneyTap, CASHe, Navi | Instant personal loans, alt-data underwriting |
| BNPL | Simpl, LazyPay | Short-term point-of-sale credit |
| Wealthtech | Zerodha, Groww, Upstox | Stock/MF investing platforms |
| Neobanks | Jupiter, Fi, Niyo | App-first banking on top of partner banks |
| Insurtech | Digit, Acko, PolicyBazaar | Digital-first insurance |
| Credit bureaus | CIBIL (TransUnion), Experian, Equifax | Maintain credit history/scores |
| Fraud/Risk-tech | Razorpay Thirdwatch, Signzy, HyperVerge | Fraud detection, KYC automation |
| Core banking software | Finacle (Infosys), TCS BaNCS | The actual software banks run on internally |
| Regulator (India) | RBI, NPCI, SEBI, IRDAI | Set rules, run infra, license entities |

---

# PART 9: PROS/CONS FRAMEWORK YOU CAN REUSE FOR ANY PS SOLUTION

When you propose a fintech solution in ANY hackathon, judges expect you to address these — build this into your pitch regardless of the exact PS:

1. **Accuracy vs speed trade-off** — can your fraud/risk model run in real-time without slowing the transaction?
2. **False positive cost** — what happens to a genuine user wrongly flagged? (friction, lost trust, support cost)
3. **Explainability** — can you explain a decision to a compliance officer or the customer, not just show a model score?
4. **Data privacy** — are you handling PII/financial data per regulations (RBI data localization, consent-based data use)?
5. **Scalability** — does it work at 10 transactions/sec AND 10,000 transactions/sec?
6. **Adaptability** — fraud patterns evolve; does your system need manual rule updates or does it learn/adapt?
7. **Cost to deploy/maintain** — is this realistic for a mid-size bank, or only a big tech giant?
8. **Regulatory alignment** — does the solution fit within RBI/NPCI/AML frameworks, or would it need new regulation to be legal?

---

# PART 10: HOW TO READ *ANY* FINTECH PS (your actual cheat method)

Ask these 8 questions on any problem statement, in order:
1. Who is the user? (customer / merchant / bank / fraud analyst / admin)
2. What financial action is happening? (pay / lend / invest / insure / verify identity)
3. What is the money flow — who owns the money at each step?
4. What is the risk being solved? (fraud / default / compliance / downtime)
5. What data/signals are available or implied? (transaction logs, device data, KYC docs, cyber telemetry)
6. What does success look like, measurably? (lower fraud %, faster approval, fewer false positives)
7. What external systems/parties are involved? (bank, NPCI, card network, bureau, insurer)
8. What's the business/regulatory constraint? (must be real-time, must be explainable, must comply with RBI)

For **your PS2 specifically**, the answers are roughly:
1. User = bank's fraud/security ops team (and indirectly, the end customer being protected)
2. Action = detecting fraud that spans both cyber intrusion and transaction misuse
3. Money flow = normal banking transactions, but the "flow" being tracked is the *attack path*: breach → account access → fraudulent transaction
4. Risk = account takeover / fraud that slips through because cyber and transaction monitoring are siloed
5. Data = login/device/IP logs (cyber) + transaction amount/frequency/beneficiary data (transactional)
6. Success = higher fraud catch rate with low false positives, ideally near real-time, with explainable alerts
7. External = could map to bank's core banking system + a SIEM (security info/event management) system
8. Constraint = must be explainable/auditable (banking compliance), must not add too much latency to real transactions

---

## FINAL NOTE
You now have enough vocabulary that no fintech PS should have an unfamiliar term. When you hit something new during the hackathon, it will almost always be a specific instance of one of these categories — come back to this doc, find the closest matching term/pattern, and you'll place it correctly.