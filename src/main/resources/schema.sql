DROP TABLE IF EXISTS friendships;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
    user_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) UNIQUE,
    email VARCHAR(50) UNIQUE,
    password_hash VARCHAR(50),
    registered_at DATE DEFAULT CURRENT_DATE,
    dob DATE,
    profile_picture_url VARCHAR(255),
    bio TEXT
);

CREATE TABLE IF NOT EXISTS posts
(
    post_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INTEGER NOT NULL,
    post_image_url VARCHAR(255),
    post_description TEXT,
    created_at DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS friendships
(
    friendship_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    source_id INTEGER NOT NULL,
    target_id INTEGER NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('PENDING', 'ACCEPTED', 'DECLINED') DEFAULT 'PENDING',
    FOREIGN KEY (source_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (target_id) REFERENCES users(user_id) ON DELETE CASCADE,
    UNIQUE (source_id, target_id)
);