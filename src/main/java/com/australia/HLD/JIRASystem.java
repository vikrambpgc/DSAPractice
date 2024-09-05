package com.australia.HLD;

/**
 * Design a JIRA system.
 * It should have the following functionalities :
 *
 * User should be able to create Task of type Story, Feature, Bugs.
 * Each can have their own status.Stories can further have subtracts.
 * Should be able to change the status of any task.
 * User should be able to create any sprint.
 * Should be able to add any task to sprint and remove from it.
 * User should be able to print 6.1) Delayed task 6.2) Sprint details Tasks 6.3) assigned to the user
 * based on Task Status Will see all Task
 * get all disableTask of sprint
 */
public class JIRASystem {

}
/**
 * Here is a high-level design for a JIRA system with the specified functionalities:
 *
 * Entities:
 *  User
 *  Task (Story, Feature, Bug)
 *  Status
 *  Sprint
 *  Subtask (for Stories)
 *
 * Relationships:
 *  A User can create multiple Tasks.
 *  A Task can have one Status.
 *  A Story can have multiple Subtasks.
 *  A Sprint can have multiple Tasks.
 *  A Task can be assigned to one User.
 *
 * Functionality:
 *  Task Creation:
 *      User can create Tasks of type Story, Feature, or Bug.
 *      Each Task can have its own Status.
 *  Status Update:
 *      User can change the Status of any Task.
 *  Sprint Management:
 *      User can create Sprints.
 *      User can add Tasks to a Sprint and remove Tasks from a Sprint.
 *  Reporting:
 *      User can print:
 *          Delayed Tasks
 *          Sprint details (Tasks, Status, etc.)
 *          Tasks assigned to the User
 *          User can view all Tasks based on Task Status.
 *          User can get all disabled Tasks of a Sprint.
 *
 * Database Schema:
 * Users Table:
     * User ID (Primary Key)
     * Name
     * Email
 * Tasks Table:
     * Task ID (Primary Key)
     * Task Type (Story, Feature, Bug)
     * Status ID (Foreign Key referencing Status Table)
     * User ID (Foreign Key referencing Users Table)
     * Sprint ID (Foreign Key referencing Sprints Table)
 * Status Table:
     * Status ID (Primary Key)
     * Status Name
 * Sprints Table:
     * Sprint ID (Primary Key)
     * Sprint Name
     * Start Date
     * End Date
 * Subtasks Table:
     * Subtask ID (Primary Key)
     * Task ID (Foreign Key referencing Tasks Table)
     * Subtask Name
 * Task Assignments Table:
     * Task ID (Foreign Key referencing Tasks Table)
     * User ID (Foreign Key referencing Users Table)
     * This design should support the required functionalities. Note that this is a high-level design, and you may need to add additional tables or fields depending on your specific requirements.
 */


/**
 * Yes, the system can be developed using a NoSQL database for horizontal scalability. Here's a high-level overview of how the schema could be adapted for a NoSQL database:
 *
 * Document-oriented database (e.g. MongoDB):
 * Collections:
 *  Users
 *  Tasks
 *  Sprints
 *  Subtasks
 *
 * Documents:
 *  User: { _id, name, email }
 *  Task: { _id, type, status, userId, sprintId, subtasks }
 *  Sprint: { _id, name, startDate, endDate, tasks }
 *  Subtask: { _id, taskId, name }
 *
 * Key-value store (e.g. Riak):
 *  Buckets:
 *      Users
 *      Tasks
 *      Sprints
 *      Subtasks
 *
 *  Keys:
 *      User: <user_id>
 *      Task: <task_id>
 *      Sprint: <sprint_id>
 *      Subtask: <subtask_id>
 *  Values:
 *      User: { name, email }
 *      Task: { type, status, userId, sprintId, subtasks }
 *      Sprint: { name, startDate, endDate, tasks }
 *      Subtask: { taskId, name }
 *
 * Graph database (e.g. Neo4j):
 *
 * Nodes:
 *  User
 *  Task
 *  Sprint
 *  Subtask
 *
 * Relationships:
 *      User-Task (CREATED)
 *      Task-Sprint (ASSIGNED_TO)
 *      Task-Subtask (HAS_SUBTASK)
 *      Sprint-Task (HAS_TASK)
 *
 * In a NoSQL database, horizontal scalability is often achieved through:
 *  Sharding: splitting data across multiple servers
 *  Replication: duplicating data across multiple servers
 *  Distributed architecture: using multiple servers to handle requests
 *
 * By using a NoSQL database and designing the schema with horizontal scalability in mind, the system can handle increased traffic and data growth more efficiently.
 */