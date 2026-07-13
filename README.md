# Beauty-Salon-Inventory-System
A Java-based console application for managing a beauty salon's inventory. Built using specialized Collections (LinkedList and ArrayList) to optimize product tracking, updating, and stock monitoring.
# Arman's Beauty Salon - Inventory Management System

A lightweight, console-based Java application designed to streamline inventory tracking for a beauty salon. This system showcases efficient data management by combining different Java Collections Framework components to optimize search, retrieval, and modification performance.

## 🚀 Features

* **Add New Products:** Register unique product IDs, categories, initial stock quantities, pricing, and system-entry timestamps.
* **Remove Products:** Safely delete out-of-stock or discontinued items from the records after a verification step.
* **Targeted Updates:** Modify individual product attributes (e.g., updating just the stock volume or status) without affecting other fields.
* **Search System:** Instantly pull up comprehensive product dossiers using indexed ID lookups.
* **Stock Status Monitoring:** Keep tabs on product levels with built-in tags (`in stock`, `low stock`, `out of stock`, `pending delivery`).

## 🛠️ Architecture & Data Structures

To balance execution speed and memory management, this project splits product attributes across two primary data structures:
* **`LinkedList`:** Utilized for `ProductID` and `ProductName` to facilitate fluid, sequential data shifting during addition and deletion phases.
* **`ArrayList`:** Utilized for `Category`, `UnitPrice`, `Quantity`, `DateCreated`, and `Status` to maximize speed when randomly accessing or updating specific product descriptors.

## 💻 Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher installed.
### Execution
1. Clone the repository:
   ```bash
   git clone [https://github.com/YOUR_USERNAME/REPOSITORY_NAME.git](https://github.com/YOUR_USERNAME/REPOSITORY_NAME.git)
