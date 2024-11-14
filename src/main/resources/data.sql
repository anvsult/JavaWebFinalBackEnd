INSERT INTO users (user_id, user_name, email, password_hash, registered_at, dob, profile_picture_url, bio)
VALUES
    (1001, 'willsmith', 'willsmith@gmail.com', 'password', '2021-01-01', '1968-09-25', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNnkvWswxo4kJ2q9fcnsEx9GD-Q_npU7cEcA&s', 'Willard Carroll Smith Jr. is an American actor and rapper known for his charismatic personality and box-office success.'),

    (1002, 'selenagomez', 'selenagomez@gmail.com', 'password123', '2022-03-15', '1992-07-22', 'https://avatarfiles.alphacoders.com/239/thumb-1920-239762.jpg', 'Selena Gomez is an American singer, actress, and producer who gained fame as a Disney star and went on to become a pop icon.'),

    (1003,'therock', 'therock@gmail.com', 'pass1234', '2022-06-12', '1972-05-02', 'https://pbs.twimg.com/profile_images/3478244961/01ebfc40ecc194a2abc81e82ab877af4_400x400.jpeg', 'Dwayne Johnson, also known as "The Rock," is a former wrestler turned actor, famous for his roles in action-packed blockbusters.'),

    (1004,'arianagrande', 'arianagrande@gmail.com', 'mypassword', '2023-04-20', '1993-06-26', 'https://www.usmagazine.com/wp-content/uploads/2022/08/Ariana-Grande-Through-Years-0004.jpg', 'Ariana Grande is a Grammy-winning pop star known for her incredible vocal range and chart-topping hits.'),

    (1005,'chrishemsworth', 'chrishemsworth@gmail.com', 'thor1234', '2023-01-30', '1983-08-11', 'https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/528854_v9_bb.jpg', 'Chris Hemsworth is an Australian actor best known for his role as Thor in the Marvel Cinematic Universe.');

INSERT INTO posts (user_id, post_image_url, post_description, created_at)
VALUES
    (1001, 'https://example.com/posts/willsmith_post.jpg', 'On set for my new movie! Can’t wait for you all to see it!', '2023-03-10 10:30:00'),

    (1002, 'https://example.com/posts/selenagomez_post.jpg', 'Recording some new music for you guys. Exciting things coming soon!', '2023-05-14 13:15:00'),

    (1003, 'https://example.com/posts/therock_post.jpg', 'Pushing my limits in the gym today. #IronParadise', '2023-06-21 18:45:00'),

    (1004, 'https://example.com/posts/arianagrande_post.jpg', 'Love you guys so much! Thanks for all the support on the new album!', '2023-08-03 15:25:00'),

    (1005, 'https://example.com/posts/chrishemsworth_post.jpg', 'Surfing in Australia! Nothing like the waves back home.', '2023-09-10 11:00:00');

INSERT INTO friendships (source_id, target_id, created_at)
VALUES
    (1001, 1002, '2023-02-20'), -- Will Smith is friends with Selena Gomez
    (1001, 1003, '2023-04-15'), -- Will Smith is friends with The Rock
    (1002, 1004, '2023-05-10'), -- Selena Gomez is friends with Ariana Grande
    (1003, 1005, '2023-06-21'), -- The Rock is friends with Chris Hemsworth
    (1004, 1005, '2023-08-10'); -- Ariana Grande is friends with Chris Hemsworth