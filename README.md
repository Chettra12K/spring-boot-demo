# Spring Boot Hello World API 🚀

សួស្តី! នេះជា project ដំបូងរបស់ខ្ញុំសម្រាប់រៀន **Spring Boot** (Java)។  
វាជា REST API សាមញ្ញដែលមាន endpoints ដូចជា `/hello` និង `/hi/{name}`។

## តើ project នេះធ្វើអ្វី?
- បង្ហាញមូលដ្ឋាន Spring Boot + REST Controller  
- ប្រើ Java 21 + Spring Boot 3.x  
- សាកល្បងជាមួយ Postman ឬ browser

## Tech Stack
- Java 21  
- Spring Boot 3.3+ (Spring Web)  
- Maven  
- VS Code + Spring Boot Extension Pack

## របៀប Run project នេះ (Installation & Quick Start)
1. Clone repo នេះ៖  
git clone https://github.com/chettra12k/demo.git
cd demo

2. Run ដោយ Maven (ត្រូវមាន JDK 21 ដំឡើងរួច)៖  
./mvnw spring-boot:run
(Windows: `mvnw.cmd spring-boot:run`)

3. បើក browser ឬ Postman សាកល្បង៖  
- http://localhost:8080/hello  
  → "សួស្តី Kun! នេះជា Spring Boot REST API ដំបូងរបស់អ្នក 🚀"  
- http://localhost:8080/hi/Kun  
  → "សួស្តី Kun! រីករាយណាស់ដែលបានជួបអ្នកនៅឆ្នាំ ២០២៦"


សូមស្វាគមន៍មកកាន់ project របស់ខ្ញុំ! បើមានសំណួរ ឬចង់ contribute សូម open issue ឬ pull request 😊