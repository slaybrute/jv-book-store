# Online book store

## Overview

This Spring Boot application serves as a book store, providing functionalities to manage users, books, categories, shopping carts, and orders. Below is a detailed list of entities present in the project:

### Entities

#### 1. User
- Represents information about a registered user.
- Includes authentication details and personal information.

#### 2. Role
- Represents the role of a user in the system (e.g., admin or user).

#### 3. Book
- Represents a book available in the store.
- Contains information such as title, author, description, and price.

#### 4. Category
- Represents a category to which a book can belong.

#### 5. ShoppingCart
- Represents a user's shopping cart.
- Contains a list of `CartItem` objects.

#### 6. CartItem
- Represents an item in a user's shopping cart.
- Associated with a specific book and quantity.

#### 7. Order
- Represents an order placed by a user.
- Contains information such as order date, total price, and delivery details.

#### 8. OrderItem
- Represents an item in a user's order.
- Associated with a specific book and quantity.

## Technologies Used
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate
- RESTful API

# API Endpoints

## Authentication API

- `POST /auth/login`: Login user
- `POST /auth/register`: Register new user
- `POST /auth/register/admin`: Register new user by admin

## User API

- `GET /users`: Get all users (Requires `ADMIN` role)
- `GET /users/by-email`: Get user by email (Requires `ADMIN` role)
- `DELETE /users/{id}`: Delete user by ID (Requires `ADMIN` role)
- `DELETE /users`: Delete user by email

## Book API

- `POST /books`: Create a new book (Requires `ADMIN` role)
- `PUT /books/{id}`: Update book by ID (Requires `ADMIN` role)
- `DELETE /books/{id}`: Delete book by ID (Requires `ADMIN` role)
- `GET /books`: Get all books by pagination
- `GET /books/{id}`: Get book by ID
- `GET /books/search`: Search books by parameters

## Category API

- `POST /categories`: Create a new category (Requires `ADMIN` role)
- `PUT /categories/{id}`: Update category by ID (Requires `ADMIN` role)
- `DELETE /categories/{id}`: Delete category by ID (Requires `ADMIN` role)
- `GET /categories`: Get all categories by pagination
- `GET /categories/{id}`: Get category by ID
- `GET /categories/{id}/books`: Get books by category ID

## Shopping Cart API

## Order API

## Setup

1. Clone the repository.
   ```bash
   git clone https://github.com/slaybrute/book-store.git
