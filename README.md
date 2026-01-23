CursorWave is an Agentic AI Assistant that enables voice-driven web browsing. It leverages Large Language Models (LLMs) to bridge the gap between natural language voice commands and automated browser actions.

## Project 
CursorWave converts natural language voice input into structured JSON schema actions. these actions are then orchestrated through a Java Selenium protocol to perform automated tasks on the web across 15 different supported actions.

## Features

Control your browser using natural speech instead of manual clicking.
Utilizes Llama models to interpret intent and map it to specific browser functions.
A sophisticated backend logic that manages the flow from voice capture to browser execution.
Supports 15 distinct actions, translating human requests into precise JSON commands for Selenium.

## Tech Stack
Language: Java

Framework: Spring Boot (indicated by HELP.md, mvnw, and pom.xml initialization)

Automation: Selenium Protocol

AI Models: Llama

Build Tool: Maven

## How it works
Voice Input: The system captures natural language audio.

LLM Processing: The Llama model parses the audio transcript to identify the user's goal.

Action Schema: The intent is converted into a standard JSON schema.

Selenium Execution: The Java-based Selenium controller executes the JSON action on the target website.
