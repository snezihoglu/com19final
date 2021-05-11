# com19final
==================================================================

### Selma Nezihoglu

Faculty: CS
<br>Phone Number: 0707725414
<br>Email: selma.nezihoglu@iaau.edu.kg


### ***The link of my web application***

> [COM19 Teachers login](https://cs204backendback.herokuapp.com/login) 

## Project Description

It is a web application that contains:
- a login page
- a registiration page
- a user profile page
- a home page
- a description page of API
- a database page where the user can add or delete data
 <br>
 
 First the user should register, create a username and a password. After that the user can use created username and password to login to the website. 
 ![Login page](https://user-images.githubusercontent.com/64955154/117888897-863eb700-b2d4-11eb-8b7b-76b2202cac7b.PNG)
 ![Rwgister page](https://user-images.githubusercontent.com/64955154/117888977-a3738580-b2d4-11eb-9245-421bdba7839b.PNG)
 <br>
 User's profile page shows up after logging in.
 ![3](https://user-images.githubusercontent.com/64955154/117889059-bd14cd00-b2d4-11eb-8f11-d695acb0f61e.PNG
 <br>
 There are two more pages:
 One is a home page:
 ![4](https://user-images.githubusercontent.com/64955154/117889659-bf2b5b80-b2d5-11eb-81ac-537607a65e45.PNG)
 One gives information about API:
![5](https://user-images.githubusercontent.com/64955154/117889711-d5391c00-b2d5-11eb-9df3-f4b08eab4d51.PNG)
## DB page Description

It is a web application that includes a Student database inside. The purpose of the project is to help students and teachers by providing contact information for their classmates and students. The project is done by html and java languages. For the database, postgreSQL is used. The application contains REST API, the further information about it is given below.
<br><br>
Here is how the web application looks like:
<br><br>
Main page:
![Main page](https://user-images.githubusercontent.com/64955154/111915540-0dc03480-8aa1-11eb-9749-821af2ab8fc6.PNG)
<br><br>
"Add Yourself" window 
![API](https://user-images.githubusercontent.com/64955154/111915634-71e2f880-8aa1-11eb-89df-a491a6d0d00a.PNG)
<br><br>
Information window for API
![AboutPage](https://user-images.githubusercontent.com/64955154/111917003-e02ab980-8aa7-11eb-870f-2b7725b63fb5.PNG)

### REST API

Here is the code for API:

```
@PostMapping("/add")
    public @ResponseBody String addNewStudent(@RequestBody Students student) {
        StudentsRepository.save(student);
        return "OK";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Students> getAllStudents() {
        return StudentsRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Students one(@PathVariable Integer id) {
        return StudentsRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/{id}")
    public @ResponseBody Students put(@RequestBody Students replaceStudents, @PathVariable Integer id) {
        return StudentsRepository.findById(id).map(Students -> {
            Students = replaceStudents;
            Students.setId(id);
            return StudentsRepository.save(Students);
        }).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void del(@PathVariable Integer id) {
        StudentsRepository.deleteById(id);
    }
```

Here we have 4 routes for each operation:

      * GET - it is used to see all of the information in a table, or a specific row by typing in the id. This method can be used by typing "/students/id" to see a specific row or "/students/all" to see all the data.
      * POST - it is used to insert information to database. This method can be used by typing"/students/add".
      * PUT - it is used to replace a data. This method is used by typing"/studentsr/id".
      * DELETE - it is used to delete a specific row by typing in the id. This method is activated by typing"/students/id".
