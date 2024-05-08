# 📚 Online Book Store

## 🌟 Overview
Welcome to the **Online Book Store**, your ultimate destination for managing and purchasing books online. Built with Spring Boot, this application comes packed with functionalities that enable seamless management of users, books, categories, shopping carts, and orders.

### Key Entities
1. **User**: Registered users with personal information and secure authentication details.
2. **Role**: Different roles like admin or user to manage platform access.
3. **Book**: Contains essential details about each book, such as title, author, description, and price.
4. **Category**: Classify books into categories for better organization.
5. **ShoppingCart**: Holds a list of selected items before finalizing the purchase.
6. **CartItem**: Individual book and its quantity within a user's shopping cart.
7. **Order**: Represents a placed order with all necessary details like date, total price, and delivery.
8. **OrderItem**: An individual item associated with an order.

### 🛠 Technologies Used
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **Hibernate**
- **RESTful API**

## 🛡 API Endpoints

### 🔑 Authentication API
- `POST /auth/login`: Log in a registered user.
- `POST /auth/register`: Register a new user.
- `POST /auth/register/admin`: Admin registration.

### 👥 User API
- `GET /users`: Retrieve all users (Admin-only).
- `GET /users/by-email`: Retrieve a user by their email (Admin-only).
- `DELETE /users/{id}`: Delete a user by ID (Admin-only).
- `DELETE /users`: Delete a user by email.

### 📚 Book API
- `POST /books`: Add a new book (Admin-only).
- `PUT /books/{id}`: Update book details by ID (Admin-only).
- `DELETE /books/{id}`: Remove a book by ID (Admin-only).
- `GET /books`: Retrieve all books with pagination.
- `GET /books/{id}`: Get book details by ID.
- `GET /books/search`: Search for books using specific parameters.

### 🗂 Category API
- `POST /categories`: Add a new category (Admin-only).
- `PUT /categories/{id}`: Update category information by ID (Admin-only).
- `DELETE /categories/{id}`: Delete a category by ID (Admin-only).
- `GET /categories`: Retrieve all categories with pagination.
- `GET /categories/{id}`: Get a category by ID.
- `GET /categories/{id}/books`: Retrieve books based on category ID.

### 🛒 Cart API
- `GET /cart`: Retrieve all items in a user's shopping cart (Authenticated users only).
- `POST /cart`: Add a new item to the shopping cart (Authenticated users only).
- `PUT /cart/cart-items/{id}`: Modify the quantity of a cart item (Authenticated users only).
- `DELETE /cart/cart-items/{id}`: Remove an item from the cart (Authenticated users only).

### 🛍 Order API
- `PATCH /orders/{id}`: Update order status by order ID (Admin-only).
- `POST /orders`: Create a new order and clear the user's cart.
- `GET /orders`: Retrieve all orders for the logged-in user with pagination.
- `GET /orders/{id}/items`: Retrieve all order items by order ID.
- `GET /orders/{orderId}/items/{itemId}`: Retrieve a specific order item by ID.

## 🚀 Setup & Installation

### Prerequisites
- Java JDK 17 or newer
- Maven

### Configuration
1. **Database Connection**: Modify `src/main/resources/application.properties` to ensure the correct database URL, username, and password are configured.
2. **Environment Variables**: Set any required environment variables (e.g., API keys, other sensitive information).

### Running the Application
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/slaybrute/book-store.git
2. **Run the Application**:
   ```bash
   java -jar target/online-bookstore-0.0.1-SNAPSHOT.jar
   
