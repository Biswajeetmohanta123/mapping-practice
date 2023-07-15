
<h1 align="center"> 
Mapping-Practice</h1>
This project is aimed at creating the basic design of the backend of Instagram. This Readme.md file will guide you through the project setup, the models used, and the API endpoints available.

>### Prerequisites
* ![MySql](https://img.shields.io/badge/DBMS-MYSQL%205.7%20or%20Higher-red)
 * ![SpringBoot](https://img.shields.io/badge/Framework-SpringBoot-green)


* ![Java](https://img.shields.io/badge/Language-Java%208%20or%20higher-yellow)

>## Installation

To run this application locally, you will need to have Java and MySQL installed on your machine.

* Clone the repository to your local machine.
* Create a new MySQL database called `Mapping`
* Update the `application.properties` file in the `src/main/resources` directory to include your MySQL username and password
* Run the application using your IDE or by running the command `mvn spring-boot:run` in the project directory
* Access the APIs using any HTTP client such as Postman or cURL.
>## Data flow
 The application is built using the SpringBoot framework and consists of four layers: DTO, model, service, and repository.-

* **DTO** -The DTO layer consists of classes that are used to transfer data between different layers of the application
* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer. In short, it consists of views i.e., frontend part.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Repository** - This layer mainatains the h2-database thing on which CRUD operations are performed
* **Model** - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.

>## API Documentation
The API endpoints will be available at http://localhost:8080.

#### Endpoints
>User Controller

This controller includes the following endpoints for user authentication:

* POST /auth/signup: create a new user account
* POST /auth/signin: log in an existing user and generate an authentication token
* PUT /auth/user: update user information

>Post Controller

This controller includes the following endpoints for posts:

* POST /post: create a new post
* GET /post/{postId}: get a specific post by ID
>### Schemas
This project is aimed at creating the basic design of the backend of Instagram. This Readme.md file will guide you through the project setup, the models used, and the API endpoints available.

## Models

Student {
@Id
private String ID;
private String name;
private String age;
private String phoneNumber;
private String branch;
private String department;

@OneToOne
private Address address;


}

Laptop{
@Id
private String ID;
private String name;
private String brand;
private Integer price;

@OneToOne
private Student student;


}

Course {
@Id
private String ID;
private String title;
private String description;
private String duration;

@ManyToMany
List<Student> studentList;
}

Book {
@Id
private String ID;

private String title;
private String author;
private String description;
private String price;

@ManyToOne
private Student student;
}

Address {
private Long addressId;private String landmark;
private String zipcode;
private String district;
private String state;
private String country;

}
>## Contributors

* [Mukesh Kumar Pal](https://github.com/Mukeshpal123)

>## Project Summary
This project includes the basic design of the backend of Mapping, including user and post models, and API endpoints for user authentication and post creation/retrieval. Further improvements can be made to include additional features such as comment and like functionality
