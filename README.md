# 📚 Spring Boot Books API

---

## CRUD Operations

### CREATE Operations

**POST /api/books** | Create Book | **201 Created**
![Create Book](images/craete.jpg)

---

**POST /api/books** | Create Book | **400 Bad Request**
![Create Bad Request](images/create_badRequest.jpg)

---

### READ Operations

**GET /api/books** | List All Books | **200 OK**
![Get All Books](images/list.jpg)

---

**GET /api/books/{id}** | Get Book by ID | **200 OK**
![Get Book by ID](images/getByid.jpg)

---

**GET /api/books/{id}** | Get Book by ID | **404 Not Found**
![Get Book Not Found](images/getById_NotFound.jpg)

---

### UPDATE Operations

**PUT /api/books/{id}** | Update Book | **200 OK**
![Update Book](images/update.jpg)

---

### DELETE Operations

**DELETE /api/books/{id}** | Delete Book | **204 No Content**
![Delete Book](images/delete.jpg)

---
