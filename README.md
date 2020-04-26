Coverage: 44.4%
## Inventory Managment System - QA Consultancy Individual Project

This is an inventory managment system based on a fantacy weapons store. Using JDBC this project is linked to a Google Cloud Platform MySQL instance in which the inventory can be managed using CRUD statments.   

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
1. Clone this repository
2. Import this as a Maven project into your chosen IDE (Eclipse)
3. Link the project to your MySQL instance by replacing IP-adresses in the following .java files:
  
  - Ims.java
  (line109)
  - CustomerDaoMysql.java
  (line024)
  - ItemDaoMysql.java
  (line025)
  - OrderDaoMysql.java
  (line025)
  - OrderlineDaoMysql.java
  (line024)
  
  4. Run the Runner file from your IDE

### Prerequisites

- Java runtime environment
- IDE (Eclipse)
- Maven version
- Git
- Jenkins

## Testing

Using JUnit and Mockito testing I tested the full functionality of each domain in the database and each of thier CRUD functions

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Dan Reed** - Developer - [DanReedQA](https://github.com/DanReedQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgements

* **Nicholas Johnson** - Software Trainer - [nickstewarttds](https://github.com/nickrstewarttds)

# InventoryManagementSystem
