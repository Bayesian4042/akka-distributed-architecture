## Akka Distributed Architecture

Akka is for building highly concurrent, distributed, and fault-tolerant systems.



## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Pre-requisite Knowledge](#Pre-requisite Knowledge)
4. [Akka Modules](#Akka Modules)
5. [Akka Actors](#Akka Actors)

## Overview
Akka is for building highly concurrent, distributed, and fault-tolerant systems.
It simplifies the implementation of concurrent and distributed application.

## Features

- **Actor Model**: At the heart of Akka is the Actor Model, which provides a higher level of abstraction for writing concurrent and distributed systems
- **Location Transparency**: Akka's design allows for systems to work the same way regardless of whether they're running on a single machine or distributed across a network.
- **Fault Tolerance**: Akka provides a "let it crash" model of failure, where failures are isolated and systems can self-heal.
- **Reactive System**:

## Pre-requisite Knowledge
1. **What is Thread**:
- In programming, thread is a sequence of instructions that can be executed independently but can concurrently with other threads in same program. This allows for better utilization of resources and can make program run faster.
- Analogy: Kitchen is processor, cores are chefs. Each doing the different task at a same time. 
2. **Context Switching**: Even on single core, it seems like multiple applications run at the same time. This is achieved by rapidly switching between different tasks.
3. **Race Condition**:
4. 
## Akka Modules
1. Akka Actors
2. Akka http
3. Akka cluster
4. Akka distributed data
5. Akka persistence
6. Akka projections
7. Akka Streams
8. Alpakka
9. Akka cluster sharding
10. Akka gRPC
11. Akka Management 

### Akka Actors
Akka Actors provide a model for building concurrent and distributed systems. In the Actor model, everything is an actor. An actor is a lightweight entity that has a mailbox and can process messages sent to it. Actors communicate by sending and receiving messages. They can also create other actors or stop them.

Here's a simple breakdown of the Akka Actor concepts:

- Actor System: The top-level entity that initializes and manages actors in Akka.
- Actor Reference (ActorRef): A handle to an actor, which can be used to send messages to it.
- Message: Information sent to actors. In Akka, messages are immutable.
- Behavior: Defines how an actor processes messages. It can be thought of as the actor's state.