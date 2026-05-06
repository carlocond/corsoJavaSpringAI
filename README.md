# Corso Java + Spring Boot + Spring AI

[![Java](https://img.shields.io/badge/Java-100%25-blue)](https://www.java.com/)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Spring AI](https://img.shields.io/badge/Spring%20AI-lab%2Fexperimental-orange)
![Build](https://img.shields.io/badge/Build-Maven%20%7C%20Gradle-informational)
![Repo](https://img.shields.io/badge/Repo-corsoJavaSpringAI-black)
![Status](![Static Badge](https://img.shields.io/badge/https%3A%2F%2Fimg.shields.io%2Fbadge%2FStatus-Completato-success))

> Questo repository raccoglie una serie di esercizi e progetti sviluppati durante un corso dedicato a **Java** con framework **Spring Boot** e **Spring AI**.

---

## 📌 Contenuti del repository

### Java Core
- sintassi, tipi, strutture dati e controllo di flusso
- classi, metodi, costruttori, incapsulamento
- gestione input/output di base
- eccezioni (try/catch), validazione e casi limite

### OOP (Object-Oriented Programming)
- ereditarietà, overriding, `super`
- polimorfismo e late binding
- astrazione e progettazione con interfacce
- composizione vs ereditarietà
- organizzazione del codice in package e responsabilità chiare

### Testing e build (quando presenti nei progetti)
- esecuzione test da CLI
- progetti Maven/Gradle a seconda del modulo

### Spring Boot (introduzione/pratica)
- struttura di un progetto Spring Boot
- concetti base: controller, service, dependency injection, microservices, restapi
- configurazione e avvio applicazione

### Spring AI (introduzione/pratica)
- integrazione “AI-ready” in applicazioni Spring (moduli dedicati quando presenti)
- concetti: prompt, modelli, integrazioni e configurazioni (in base agli esercizi del corso)

Il repository è organizzato in cartelle tematiche e progressive.

---

## 🧭 Obiettivo del corso (e del repo)

L’obiettivo è costruire una base solida su:

- **Fondamenti Java** (tipi, classi, metodi, OOP)
- **OOP avanzata** (interfacce, overriding, polimorfismo)
- **Best practice** (organizzazione del codice, leggibilità, riuso)
- Introduzione e pratica con **Spring Boot**
- Sviluppo di Web App basate su microservizi, servizi rest, api...
- Approccio moderno con **Spring AI** (integrazione AI nelle app Spring)

---

## 🧰 Requisiti

Consigliati (in base agli esercizi/progetti):

- **Java 17+** (o la versione richiesta dal corso)
- IDE: **IntelliJ IDEA** / **Eclipse** / **VS Code**
- (Per i moduli Spring) **Maven** o **Gradle**
- Git

---

## ▶️ Come eseguire gli esercizi

### 1) Clona il repository
```bash
git clone https://github.com/carlocond/corsoJavaSpringAI.git
cd corsoJavaSpringAI
```

### 2) Apri una cartella (es. `Esercizio 1`)
Ogni esercizio può essere:
- un piccolo progetto Java “semplice” (con `main`)
- oppure un progetto strutturato (Maven/Gradle), a seconda di come è stato creato durante il corso

### 3) Esegui
- Se è un progetto “semplice”: esegui la classe `Main` (o equivalente) dall’IDE
- Se è Maven:
  ```bash
  mvn test
  mvn exec:java
  ```
- Se è Gradle:
  ```bash
  ./gradlew test
  ./gradlew run
  ```
---

## 🤝 Contributi

Se vuoi proporre miglioramenti:

1. Fai una fork
2. Crea un branch (`feature/qualcosa`)
3. Apri una Pull Request con una descrizione chiara

---

## 📝 Licenza

**senza licenza esplicita**.

---

## ✉️ Contatti
Repo mantenuto da **@carlocond**.  
