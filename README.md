# 🏭 ShopFloor Copilot

> AI-powered production planning assistant for factory supervisors — built with Java Spring Boot, React, and Gemini AI.

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-green?style=flat-square&logo=springboot)
![React](https://img.shields.io/badge/React-18-blue?style=flat-square&logo=react)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue?style=flat-square&logo=postgresql)
![Gemini AI](https://img.shields.io/badge/Gemini-AI-purple?style=flat-square&logo=google)

---

## 🚨 The Problem

Factory supervisors walk in every morning facing chaos:
- 4 workers called in sick
- Machine 3 is running slow
- Order #442 is urgent and the client is calling
- Raw material for Order #445 hasn't arrived yet

They make 50+ critical decisions **from memory and gut instinct** every single day. If they're wrong, the entire day's production suffers — costing the factory lakhs of rupees.

**Existing solutions (IBM, Siemens, GE) start at ₹40,00,000/year** — completely out of reach for small and mid-size Indian manufacturers.

---

## ✅ The Solution

ShopFloor Copilot gives every factory supervisor a **senior production planner in their pocket — for free.**

The supervisor types today's situation in plain English. The AI reads it and instantly generates:

- 📋 A complete production plan with timing and machine assignments
- ⚠️ Risks to watch out for today
- 💡 One key tip from a 20-year veteran planner
- 📁 Everything saved to history for future reference

---

## 🎯 Demo

**Input:**
```
We have 3 orders today. Order #442 is urgent - 500 units, 
material ready. Order #445 - 200 units, material arrives at noon. 
Machine 3 is running slow. 18 of 22 workers present.
```

**AI Output:**
```
📋 TODAY'S PRODUCTION PLAN

▶ 7:00 AM — Start Order #442 on Machines 1, 2, 4
   Assign 12 workers from A-shift. Target: done by 1:30 PM ✅

▶ 12:30 PM — Start Order #445 once material arrives
   Machines 1 & 2 free by then. 6 workers sufficient.

⚠️ WATCH OUT FOR:
Machine 3 should handle light tasks only today.
Monitor #442 progress at 10 AM — flag if behind schedule.

💡 SUPERVISOR TIP:
Brief your team lead on the noon material arrival so 
Order #445 starts without delay.
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Frontend | React 18 + CSS-in-JS |
| Backend | Java 17 + Spring Boot 4 |
| Database | PostgreSQL 17 |
| AI | Google Gemini API |
| ORM | Spring Data JPA + Hibernate |
| Build | Maven |

---

## 🏗️ Architecture

```
React Frontend (port 3000)
        ↓ HTTP POST /api/plans/generate
Spring Boot REST API (port 8080)
        ↓ Prompt engineering
Gemini AI API
        ↓ Structured plan
PostgreSQL Database (saves every plan)
        ↓
React displays result card
```

---

## 📁 Project Structure

```
ShopFloorCopilot/
├── copilot/                    # Spring Boot backend
│   └── src/main/java/
│       └── com/shopfloor/copilot/
│           ├── controller/     # REST API endpoints
│           ├── service/        # Business logic + AI integration
│           ├── repository/     # Database layer
│           └── model/          # JPA entities
└── frontendcd/                 # React frontend
    └── src/
        └── App.js              # Main UI component
```

---

## 🚀 Running Locally

### Prerequisites
- Java 17+
- PostgreSQL 17
- Node.js 18+
- Gemini API key (free at aistudio.google.com)

### Backend Setup

```bash
# Create database
psql -U postgres -c "CREATE DATABASE shopfloor;"

# Configure application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/shopfloor
spring.datasource.username=postgres
spring.datasource.password=yourpassword
gemini.api.key=YOUR_GEMINI_API_KEY

# Run
cd copilot/copilot
./mvnw spring-boot:run
```

Backend starts at `http://localhost:8080`

### Frontend Setup

```bash
cd frontendcd
npm install
npm start
```

Frontend starts at `http://localhost:3000`

---

## 📊 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/plans/generate` | Generate AI production plan |
| GET | `/api/plans` | Get all past plans |

### Sample Request

```json
POST /api/plans/generate
{
  "situation": "Order #442 urgent - 500 units ready. Machine 3 slow. 18/22 workers present.",
  "totalWorkers": 22,
  "presentWorkers": 18
}
```

---

## 💡 Why This Project

> Small and mid-size manufacturers in India run on gut instinct and WhatsApp messages. The tools that exist cost lakhs per year. I built ShopFloor Copilot to show what's possible when you combine modern AI with practical domain knowledge — a production planner that any factory can afford.

---

## 👩‍💻 Built By

**Anshika Kalmali** — Full Stack Developer  
📧 anshikakalmali05@gmail.com  
🔗 [LinkedIn](https://linkedin.com/in/anshika-kalmali-a31a2b326/)  
🎓 B.E. Computer Science, MLR Institute of Technology (2023-2027)

---

## 📄 License

MIT License — feel free to use and build on this!
