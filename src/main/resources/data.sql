-- Sample Users (password is 'password' encrypted with BCrypt)
INSERT INTO users (name, email, password, role) VALUES
('Admin User', 'admin@example.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ADMIN'),
('John Doe', 'john@example.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'USER'),
('Test User', 'test@test.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'USER');  -- Password is: password

-- Sample Books
INSERT INTO books (title, author, price) VALUES
-- Classic Literature
('The Great Gatsby', 'F. Scott Fitzgerald', 9.99),
('To Kill a Mockingbird', 'Harper Lee', 12.99),
('1984', 'George Orwell', 10.99),
('Pride and Prejudice', 'Jane Austen', 8.99),
('The Catcher in the Rye', 'J.D. Salinger', 11.99),

-- Fantasy/Sci-Fi
('The Hobbit', 'J.R.R. Tolkien', 14.99),
('The Lord of the Rings', 'J.R.R. Tolkien', 24.99),
('Harry Potter and the Sorcerer''s Stone', 'J.K. Rowling', 15.99),
('Dune', 'Frank Herbert', 18.99),
('The Name of the Wind', 'Patrick Rothfuss', 16.99),

-- Mystery/Thriller
('The Da Vinci Code', 'Dan Brown', 13.99),
('Gone Girl', 'Gillian Flynn', 12.99),
('The Girl with the Dragon Tattoo', 'Stieg Larsson', 14.99),
('The Silent Patient', 'Alex Michaelides', 16.99),
('The Thursday Murder Club', 'Richard Osman', 19.99),

-- Contemporary Fiction
('The Alchemist', 'Paulo Coelho', 9.99),
('Normal People', 'Sally Rooney', 13.99),
('Where the Crawdads Sing', 'Delia Owens', 15.99),
('The Midnight Library', 'Matt Haig', 17.99),
('The Seven Husbands of Evelyn Hugo', 'Taylor Jenkins Reid', 16.99),

-- Non-Fiction
('Sapiens', 'Yuval Noah Harari', 22.99),
('Atomic Habits', 'James Clear', 20.99),
('The Power of Now', 'Eckhart Tolle', 15.99),
('Thinking, Fast and Slow', 'Daniel Kahneman', 19.99),
('A Brief History of Time', 'Stephen Hawking', 21.99); 