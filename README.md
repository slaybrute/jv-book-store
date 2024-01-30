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

## User API

- `/api/users` - Get all users
- `/api/users/{userId}` - Get user by ID
- `/api/users/register` - Register a new user
- `/api/users/update` - Update user details

## Book API

- `/api/books` - Get all books
- `/api/books/{bookId}` - Get book by ID
- `/api/books/add` - Add a new book
- `/api/books/update` - Update book details

## Category API

- `/api/categories` - Get all categories
- `/api/categories/{categoryId}` - Get category by ID
- `/api/categories/add` - Add a new category

## Shopping Cart API

- `/api/shopping-carts/{userId}` - Get user's shopping cart
- `/api/shopping-carts/add-item` - Add an item to the shopping cart
- `/api/shopping-carts/remove-item` - Remove an item from the shopping cart

## Order API

- `/api/orders/{userId}` - Get user's orders
- `/api/orders/place-order` - Place a new order

## Setup

1. Clone the repository.
   ```bash
   git clone https://github.com/slaybrute/book-store.git
