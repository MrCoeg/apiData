Database menggunkan MySql yang sudah tersedia di xampp dengan port 3307 dan nama database phplogin
/* jika ingin mengubah konfigurasi di atas, edit file application.properties yang berada di path
*  ...\demo\src\main\resources 

List of Command
asumsi bahwa localhost menggunakan port 8080

GET
localhost:8080/api/lecturer  --> Get All Lecturer
localhost:8080/api/lecturer/{Long lecturerId}  --> Get Lecturer By Id

localhost:8080/api/scholar  --> Get All Scholar
localhost:8080/api/scholar/{Long scholarId}  --> Get ScholarBy Id

localhost:8080/api/subject  --> Get All Subject
localhost:8080/api/subject/{Long subjectId}  --> Get SubjectBy Id

POST
localhost:8080/api/lecturer/enrollment/{Long lecturerId}/{Long subjectId} --> enroll lecturer to spesific subject
localhost:8080/api/scholar/enrollment/{Long scholarId}/{Long subjectId} --> enroll scholar to spesific subject

localhost:8080/api/lecturer --> Add New Lecturer (Request Body String name, String email, LocalDate dob)
localhost:8080/api/scholar --> Add New Scholar (Request Body String name, String email, LocalDate dob)
localhost:8080/api/subject --> Add New Subject (Request Body String name)

Delete
localhost:8080/api/lecturer/{Long lecturerId}  --> Delete Lecturer By Id
localhost:8080/api/scholar/{Long scholarId}  --> Delete ScholarBy Id
localhost:8080/api/subject/{Long lecturerId}  --> Delete SubjectBy Id

PUT
localhost:8080/api/lecturer/{Long lecturerId}?name={String value}&email={String value}--> Update Lecturer By Id
localhost:8080/api/scholar/{Long scholarId}?name={String value}&email={String value}  --> Update ScholarBy Id
localhost:8080/api/subject/{Long lecturerId}?name={String value}  --> Update SubjectBy Id