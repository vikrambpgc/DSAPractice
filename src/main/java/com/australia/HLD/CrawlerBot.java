package com.australia.HLD;
/**
 * https://www.linkedin.com/pulse/system-design-designing-web-crawler-shashank-singh-l1w4f/
 *
 *
 * Components:
 * URL Frontier:
 *      Data structure: Queue (e.g., LinkedList)
 *      Stores URLs to be crawled
 * URL Filter:
 *      Filters out URLs based on rules (e.g., domain, extension, etc.)
 * HTTP Client:
 *      Sends HTTP requests to URLs
 *      Handles responses (200, 404, etc.)
 * HTML Parser:
 *      Parses HTML content of web pages
 *         Extracts links, metadata, etc.
 * Data Storage:
 *      Stores crawled data (e.g., MySQL, MongoDB, etc.)
 * Thread Pool:
 *      Manages multiple threads for concurrent crawling
 *
 *
 * Workflow:
 * URL Frontier:
 *      Add seed URLs to the queue
 *      Continuously poll URLs from the queue
 * URL Filter:
 *      Check if URL is valid and should be crawled
 * HTTP Client:
 *      Send HTTP request to URL
 *      Handle response and extract HTML content
 * HTML Parser:
 *      Parse HTML content and extract links, metadata, etc.
 *      Add new URLs to URL Frontier
 * Data Storage:
 *      Store crawled data in database or file system
 * Thread Pool:
 *      Manage multiple threads for concurrent crawling
 */

public class CrawlerBot {
    private UrlFrontier urlFrontier;
    private UrlFilter urlFilter;
    private HttpClient httpClient;
    private HtmlParser htmlParser;
    private DataStorage dataStorage;
    private ThreadPool threadPool;

    public CrawlerBot() {
        // Initialize components
    }

    public void startCrawling() {
        // Start crawling process
    }
}

/**
 *
 * To scale the web crawler bot in a distributed system, consider the following:
 * Distributed URL Frontier:
 *        Use a distributed queue (e.g., Apache Kafka, RabbitMQ) to store URLs.
 *        Multiple nodes can consume URLs from the queue.
 * Distributed Data Storage:
 *        Use a distributed database (e.g., Apache Cassandra, MongoDB) to store crawled data.
 *        Ensure data consistency and availability across nodes.
 * Node Coordination:
 *        Use a coordination system (e.g., Apache ZooKeeper, etcd) to manage node registration, heartbeats, and task assignments.
 * Load Balancing:
 *        Use a load balancer (e.g., HAProxy, NGINX) to distribute incoming requests across nodes.
 * Node Scalability:
 *        Design nodes to be stateless, allowing easy addition or removal of nodes.
 *        Use containerization (e.g., Docker) and orchestration tools (e.g., Kubernetes) for node management.
 * Communication:
 *        Use message passing (e.g., Apache Kafka, RabbitMQ) or RPC (e.g., gRPC) for inter-node communication.
 * Fault Tolerance:
 *        Implement retry mechanisms and circuit breakers to handle node failures.
 *        Use monitoring and logging tools to detect and respond to issues.
 * Distributed Architecture:
 *    Master Node:
 *       Responsible for node coordination, task assignment, and monitoring.
 *    Worker Nodes:
 *        Consume URLs from the distributed queue, crawl, and store data.
 * Storage Nodes:
 *        Store crawled data in a distributed database.

 * Example Tools and Technologies:
 * Apache Kafka or RabbitMQ for distributed queue
 * Apache Cassandra or MongoDB for distributed database
 * Apache ZooKeeper or etcd for node coordination
 * HAProxy or NGINX for load balancing
 * Docker and Kubernetes for node management
 * Apache Kafka or gRPC for inter-node communication
 * By applying these principles and tools, you can design a scalable and fault-tolerant distributed web crawler bot.
 */