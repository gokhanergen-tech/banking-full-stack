# Banking Application

Bu proje, temel bankacılık işlemlerini (hesap yönetimi, para transferi, işlem geçmişi vb.) içeren tam yığın bir uygulamadır. Proje hem frontend hem backend katmanından oluşur ve PostgreSQL veritabanı kullanır.

---

## 🔧 Teknolojiler

### Backend

- Java 17 (Spring Boot)
- Spring Security, Spring Data JPA
- PostgreSQL
- Maven

### Frontend

- React (Vite)
- Context API
- Ant Design
- Axios
- SCSS

---

### Frontend Kurulum ve Çalıştırma

```bash
npm install
npm run dev
```

## 🐳 Docker ile Veritabanı Başlatma

İsteğe bağlı olarak PostgreSQL veritabanını Docker ile başlatabilirsiniz:

```bash
docker-compose -f docker-compose.dev.yml up postgres_db
```
