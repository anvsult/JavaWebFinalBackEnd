INSERT INTO users (user_name, email, password_hash, registered_at, dob, profile_picture_url, bio)
VALUES
    ('willsmith', 'willsmith@gmail.com', 'password', '2021-01-01', '1968-09-25', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNnkvWswxo4kJ2q9fcnsEx9GD-Q_npU7cEcA&s', 'Willard Carroll Smith Jr. is an American actor and rapper known for his charismatic personality and box-office success.'),

    ('selenagomez', 'selenagomez@gmail.com', 'password123', '2022-03-15', '1992-07-22', 'https://example.com/profile/selenagomez.jpg', 'Selena Gomez is an American singer, actress, and producer who gained fame as a Disney star and went on to become a pop icon.'),

    ('therock', 'therock@gmail.com', 'pass1234', '2022-06-12', '1972-05-02', 'https://example.com/profile/therock.jpg', 'Dwayne Johnson, also known as "The Rock," is a former wrestler turned actor, famous for his roles in action-packed blockbusters.'),

    ('arianagrande', 'arianagrande@gmail.com', 'mypassword', '2023-04-20', '1993-06-26', 'https://example.com/profile/arianagrande.jpg', 'Ariana Grande is a Grammy-winning pop star known for her incredible vocal range and chart-topping hits.'),

    ('chrishemsworth', 'chrishemsworth@gmail.com', 'thor1234', '2023-01-30', '1983-08-11', 'https://example.com/profile/chrishemsworth.jpg', 'Chris Hemsworth is an Australian actor best known for his role as Thor in the Marvel Cinematic Universe.');

INSERT INTO posts (user_id, post_image_url, post_description, created_at)
VALUES
    (1, 'https://example.com/posts/willsmith_post.jpg', 'On set for my new movie! Can’t wait for you all to see it!', '2023-03-10 10:30:00'),

    (2, 'https://example.com/posts/selenagomez_post.jpg', 'Recording some new music for you guys. Exciting things coming soon!', '2023-05-14 13:15:00'),

    (3, 'https://example.com/posts/therock_post.jpg', 'Pushing my limits in the gym today. #IronParadise', '2023-06-21 18:45:00'),

    (4, 'https://example.com/posts/arianagrande_post.jpg', 'Love you guys so much! Thanks for all the support on the new album!', '2023-08-03 15:25:00'),

    (5, 'https://example.com/posts/chrishemsworth_post.jpg', 'Surfing in Australia! Nothing like the waves back home.', '2023-09-10 11:00:00');

INSERT INTO friendships (source_id, target_id, created_at)
VALUES
    (1, 2, '2023-02-20'), -- Will Smith is friends with Selena Gomez
    (1, 3, '2023-04-15'), -- Will Smith is friends with The Rock
    (2, 4, '2023-05-10'), -- Selena Gomez is friends with Ariana Grande
    (3, 5, '2023-06-21'), -- The Rock is friends with Chris Hemsworth
    (4, 5, '2023-08-10'); -- Ariana Grande is friends with Chris Hemsworth