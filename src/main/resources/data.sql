INSERT INTO users (user_name, email, password_hash, registered_at, dob, profile_picture_url, bio)
VALUES
    ( 'willsmith', 'willsmith@gmail.com', 'password', '2021-01-01', '1968-09-25', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNnkvWswxo4kJ2q9fcnsEx9GD-Q_npU7cEcA&s', 'Willard Carroll Smith Jr. is an American actor and rapper known for his charismatic personality and box-office success.'),
    ( 'selenagomez', 'selenagomez@gmail.com', 'password123', '2022-03-15', '1992-07-22', 'https://avatarfiles.alphacoders.com/239/thumb-1920-239762.jpg', 'Selena Gomez is an American singer, actress, and producer who gained fame as a Disney star and went on to become a pop icon.'),
    ('therock', 'therock@gmail.com', 'pass1234', '2022-06-12', '1972-05-02', 'https://pbs.twimg.com/profile_images/3478244961/01ebfc40ecc194a2abc81e82ab877af4_400x400.jpeg', 'Dwayne Johnson, also known as "The Rock," is a former wrestler turned actor, famous for his roles in action-packed blockbusters.'),
    ('arianagrande', 'arianagrande@gmail.com', 'mypassword', '2023-04-20', '1993-06-26', 'https://www.usmagazine.com/wp-content/uploads/2022/08/Ariana-Grande-Through-Years-0004.jpg', 'Ariana Grande is a Grammy-winning pop star known for her incredible vocal range and chart-topping hits.'),
    ('chrishemsworth', 'chrishemsworth@gmail.com', 'thor1234', '2023-01-30', '1983-08-11', 'https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/528854_v9_bb.jpg', 'Chris Hemsworth is an Australian actor best known for his role as Thor in the Marvel Cinematic Universe.');

INSERT INTO posts (user_id, post_image_url, post_description, created_at)
VALUES
    (1, 'https://example.com/posts/willsmith_post1.jpg', 'On set for my new movie! Can’t wait for you all to see it!', '2023-03-10 10:30:00'),
    (1, 'https://example.com/posts/willsmith_post2.jpg', 'Family time is the best time. Cherishing every moment!', '2023-03-12 14:20:00'),
    (1, 'https://example.com/posts/willsmith_post3.jpg', 'Throwback to my first movie premiere. What a journey!', '2023-03-15 09:00:00'),
    (1, 'https://example.com/posts/willsmith_post4.jpg', 'Grateful for another day of doing what I love!', '2023-03-18 18:00:00'),
    (1, 'https://example.com/posts/willsmith_post5.jpg', 'Behind the scenes with an incredible cast and crew!', '2023-03-20 11:45:00'),

    (2, 'https://example.com/posts/selenagomez_post1.jpg', 'Recording some new music for you guys. Exciting things coming soon!', '2023-05-14 13:15:00'),
    (2, 'https://example.com/posts/selenagomez_post2.jpg', 'Morning coffee before hitting the studio. ☕', '2023-05-16 09:30:00'),
    (2, 'https://example.com/posts/selenagomez_post3.jpg', 'Had the best time meeting fans at the event today!', '2023-05-18 16:45:00'),
    (2, 'https://example.com/posts/selenagomez_post4.jpg', 'The creative process is everything. Stay inspired!', '2023-05-20 20:00:00'),
    (2, 'https://example.com/posts/selenagomez_post5.jpg', 'Chillin’ at home with my fur babies 🐾.', '2023-05-22 11:00:00'),

    (3, 'https://example.com/posts/therock_post1.jpg', 'Pushing my limits in the gym today. #IronParadise', '2023-06-21 18:45:00'),
    (3, 'https://example.com/posts/therock_post2.jpg', 'Late-night meal prep. Fuel the body right!', '2023-06-23 22:00:00'),
    (3, 'https://example.com/posts/therock_post3.jpg', 'Filming some intense action scenes today!', '2023-06-25 12:30:00'),
    (3, 'https://example.com/posts/therock_post4.jpg', 'Reflecting on the journey. Stay hungry, stay humble.', '2023-06-27 19:15:00'),
    (3, 'https://example.com/posts/therock_post5.jpg', 'Epic cheat meal incoming. Life’s about balance.', '2023-06-29 21:00:00'),

    (4, 'https://example.com/posts/arianagrande_post1.jpg', 'Love you guys so much! Thanks for all the support on the new album!', '2023-08-03 15:25:00'),
    (4, 'https://example.com/posts/arianagrande_post2.jpg', 'Spending some downtime with my favorite books.', '2023-08-05 11:00:00'),
    (4, 'https://example.com/posts/arianagrande_post3.jpg', 'Rehearsals are in full swing! Can’t wait for the tour!', '2023-08-07 18:30:00'),
    (4, 'https://example.com/posts/arianagrande_post4.jpg', 'So grateful for the love and positivity from my fans.', '2023-08-09 14:45:00'),
    (4, 'https://example.com/posts/arianagrande_post5.jpg', 'Baking some cookies today. Who wants one? 🍪', '2023-08-11 16:20:00'),

    (5, 'https://example.com/posts/chrishemsworth_post1.jpg', 'Surfing in Australia! Nothing like the waves back home.', '2023-09-10 11:00:00'),
    (5, 'https://example.com/posts/chrishemsworth_post2.jpg', 'Training hard for my next role. Feeling strong!', '2023-09-12 09:15:00'),
    (5, 'https://example.com/posts/chrishemsworth_post3.jpg', 'Spending time with family is everything to me.', '2023-09-14 17:00:00'),
    (5, 'https://example.com/posts/chrishemsworth_post4.jpg', 'Nature is the best therapy. Take a hike!', '2023-09-16 08:30:00'),
    (5, 'https://example.com/posts/chrishemsworth_post5.jpg', 'Grateful for the opportunities this year has brought.', '2023-09-18 20:45:00');

INSERT INTO friendships (source_id, target_id, created_at, status)
VALUES
    (1, 2, '2023-02-20', 'ACCEPTED'), -- Will Smith is friends with Selena Gomez
    (1, 3, '2023-04-15', 'ACCEPTED'), -- Will Smith is friends with The Rock
    (2, 4, '2023-05-10', 'ACCEPTED'), -- Selena Gomez is friends with Ariana Grande
    (3, 5, '2023-06-21', 'ACCEPTED'), -- The Rock is friends with Chris Hemsworth
    (4, 5, '2023-08-10', 'ACCEPTED'); -- Ariana Grande is friends with Chris Hemsworth