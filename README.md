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
{
"nm_barang": "Keyboard",
"jml_stok": 10,
"no_seri": "KBD12345",
"additionalInfo": {
"brand": "Logitech",
"color": "Black"
}
}

Send `image` as separate form-data field.

---

## ⚙️ How to Run

1. Clone the repo
```bash
git clone https://github.com/tyaswardani/spring-boot-inventory-api-simple.git
cd inventory-springboot-api
```

2. Configure application.properties (PostgreSQL DB)
3. Run the app

## Postman Test
1. Get All Data
<img width="1330" height="587" alt="image" src="https://github.com/user-attachments/assets/cfc0fc9d-b24e-475b-922d-077815739a98" />

2. Post Data
<img width="1334" height="584" alt="image" src="https://github.com/user-attachments/assets/ca7c3d6e-b542-4f32-8ccb-c7c3f0fbe0fc" />

3. Get Data by ID
<img width="1326" height="581" alt="image" src="https://github.com/user-attachments/assets/433f390a-7ce8-4414-8dc1-ec314dd4df93" />

4. Delete Data by ID
<img width="1344" height="446" alt="image" src="https://github.com/user-attachments/assets/9f97621e-c928-470a-80b1-29f2829c9ce7" />
