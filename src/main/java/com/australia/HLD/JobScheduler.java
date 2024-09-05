package com.australia.HLD;

public class JobScheduler {
}

/**
 * Job Scheduler System with Recurring Jobs
 * Here's a high-level design for a job scheduler system with recurring jobs:
 *
 * Components:
 * Job Repository: Stores job definitions, including recurring job schedules.
 * Scheduler: Responsible for scheduling jobs at the designated time.
 * Job Executor: Executes the scheduled jobs.
 * Trigger Manager: Manages recurring job triggers (e.g., cron expressions).
 * Notification Service: Sends notifications for job failures or successes (optional).
 *
 * Communication Flow:
 *
 * Job Submission:
 *      Client submits a job (recurring or one-time) to the Job Repository.
 *      Job Repository stores the job definition.
 * Scheduling:
 *      Scheduler queries the Job Repository for jobs due to run.
 *      Scheduler uses the Trigger Manager to evaluate recurring job triggers.
 *      Scheduler schedules jobs for execution.
 * Job Execution:
 *      Job Executor receives scheduled jobs from the Scheduler.
 *      Job Executor executes the jobs.
 * Trigger Evaluation:
 *      Trigger Manager evaluates recurring job triggers (e.g., cron expressions).
 *      Trigger Manager notifies the Scheduler of upcoming job executions.
 * Notification:
 *      Job Executor notifies the Notification Service of job failures or successes (if configured).
 *
 * Additional Components (optional):
 * Load Balancer: Distributes job execution across multiple Job Executors.
 * Monitoring Service: Tracks job execution metrics and system health.
 * User Interface: Provides a UI for job submission, monitoring, and management.
 *
 * ** Technologies:**
 * Job Repository: Relational database (e.g., MySQL) or NoSQL database (e.g., MongoDB).
 * Scheduler: Quartz Scheduler, Apache Airflow, or similar.
 * Job Executor: Custom implementation or use existing libraries (e.g., Java Executor Framework).
 * Trigger Manager: Quartz Scheduler's cron trigger or similar.
 * Notification Service: Custom implementation or use existing libraries (e.g., Apache Kafka, RabbitMQ).
 * This design provides a basic framework for a job scheduler system with recurring jobs. You can modify and extend it based on your specific requirements.
 *
 * Job Executor Queue Consumption
 *      To allow Job Executors to pick up jobs from the queue, you can use a message broker or a queueing system like:
 *      Apache Kafka: Job Scheduler produces messages to a Kafka topic, and Job Executors consume from the topic.
 *      RabbitMQ: Job Scheduler produces messages to a RabbitMQ queue, and Job Executors consume from the queue.
 *      Amazon SQS: Job Scheduler sends messages to an SQS queue, and Job Executors receive messages from the queue.
 *
 * Load Balancer and Job Executor Registration
 *      To distribute jobs across multiple Job Executors, you can use a Load Balancer to front the list of Job Executors. Here's a possible approach:
 *
 * Job Executor Registration: Each Job Executor registers itself with the Load Balancer, providing its availability and capacity information.
 *      Load Balancer: The Load Balancer maintains a list of available Job Executors and their capacities.
 *      Job Assignment: When a job is scheduled, the Load Balancer assigns the job to an available Job Executor based on its capacity and availability.
 *
 * Preventing Job Executors from Fighting for Messages
 *      To prevent multiple Job Executors from consuming the same message, you can use:
 *      Message Acknowledgment: Job Executors acknowledge messages after consumption, ensuring that only one executor processes each message.
 *      Message Locking: Use a locking mechanism, like Redis or ZooKeeper, to lock messages while they're being processed, preventing other executors from consuming the same message.
 *      Queue Configuration: Configure the queue to allow only one consumer to consume a message at a time (e.g., Kafka's "consume" protocol).
 *
 * By implementing these mechanisms, you can ensure that Job Executors efficiently consume jobs from the queue without conflicts.
 */
