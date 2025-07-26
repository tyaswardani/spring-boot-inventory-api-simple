# spring-boot-inventory-api-simple
📦 API REST Spring Boot untuk mengelola stok barang. Mendukung upload gambar, data JSONB, dan operasi CRUD dengan PostgreSQL.

---

## 🚀 Features

- ✅ Create, Read, Update, Delete Stock Items
- 🖼 Upload and display product images (JPG/PNG)
- 🧠 JSONB support for `additionalInfo`
- 📥 Multipart Form Data handling
- 📊 Logging using Log4j2
- 🧪 DTO pattern for data transfer

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Log4j2

---

## 📌 API Endpoints

| Method | Endpoint             | Description        |
|--------|----------------------|--------------------|
| POST   | `/api/stocks`        | Create stock item  |
| GET    | `/api/stocks`        | List all stock     |
| GET    | `/api/stocks/{id}`   | Get stock by ID    |
| PUT    | `/api/stocks/{id}`   | Update stock       |
| DELETE | `/api/stocks/{id}`   | Delete stock       |
| GET    | `/api/stocks/{id}/image` | Get product image |

---

## 📂 Request Format (multipart/form-data)

