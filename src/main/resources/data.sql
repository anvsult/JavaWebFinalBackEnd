INSERT INTO users (user_name, email, password_hash, registered_at, dob, profile_picture_url, bio)
VALUES
    ('willsmith', 'willsmith@gmail.com', 'password', '2021-01-01', '1968-09-25', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNnkvWswxo4kJ2q9fcnsEx9GD-Q_npU7cEcA&s', 'Willard Carroll Smith Jr. is an American actor and rapper known for his charismatic personality and box-office success.'),

    ('selenagomez', 'selenagomez@gmail.com', 'password123', '2022-03-15', '1992-07-22', 'https://avatarfiles.alphacoders.com/239/thumb-1920-239762.jpg', 'Selena Gomez is an American singer, actress, and producer who gained fame as a Disney star and went on to become a pop icon.'),

    ('therock', 'therock@gmail.com', 'pass1234', '2022-06-12', '1972-05-02', 'https://pbs.twimg.com/profile_images/3478244961/01ebfc40ecc194a2abc81e82ab877af4_400x400.jpeg', 'Dwayne Johnson, also known as "The Rock," is a former wrestler turned actor, famous for his roles in action-packed blockbusters.'),

    ('arianagrande', 'arianagrande@gmail.com', 'mypassword', '2023-04-20', '1993-06-26', 'https://www.usmagazine.com/wp-content/uploads/2022/08/Ariana-Grande-Through-Years-0004.jpg', 'Ariana Grande is a Grammy-winning pop star known for her incredible vocal range and chart-topping hits.'),

    ('chrishemsworth', 'chrishemsworth@gmail.com', 'thor1234', '2023-01-30', '1983-08-11', 'https://www.famousbirthdays.com/faces/hemsworth-chris-image.jpg', 'Chris Hemsworth is an Australian actor best known for his role as Thor in the Marvel Cinematic Universe.');

INSERT INTO posts (user_id, post_image_url, post_description, created_at)
VALUES
    (1, 'https://static.wikia.nocookie.net/disney/images/7/79/Will_Smith.jpg', 'On set for my new movie! Can’t wait for you all to see it!', '2024-03-10 10:30:00'),
    (1, 'https://people.com/thmb/IVD6q9ssV0CHibDDy8l2LZlugtU=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(939x438:941x440)/will-smith-family-1-2f2d069077c34103b3ff5a10059d8f09.jpg', 'Family time is the best time. Cherishing every moment!', '2024-03-12 14:20:00'),
    (1, 'https://upload.wikimedia.org/wikipedia/commons/5/55/TechCrunch_Disrupt_San_Francisco_2019_-_Day_1_%2848834070763%29_%28cropped%29.jpg', 'Throwback to my first movie premiere. What a journey!', '2024-03-15 09:00:00'),
    (1, 'https://www.cheatsheet.com/wp-content/uploads/2021/06/Independence-Day.jpg', 'Grateful for another day of doing what I love!', '2024-03-18 18:00:00'),
    (1, 'https://www.fxguide.com/wp-content/uploads/2019/10/pics19.jpg', 'Behind the scenes with an incredible cast and crew!', '2024-03-20 11:45:00'),

    (2, 'https://hollywoodlife.com/wp-content/uploads/2015/07/selena-gomez-rex-gallery-10.jpg?w=680', 'Recording some new music for you guys. Exciting things coming soon!', '2024-05-14 13:15:00'),
    (2, 'https://www.celebsfirst.com/wp-content/uploads/2018/02/selena-gomez-looks-casual-but-trendy-as-she-steps-out-to-get-coffee-with-a-friend-in-studio-city-los-angeles-080218_3.jpg', 'Morning coffee before hitting the studio. ☕', '2024-05-16 09:30:00'),
    (2, 'https://hips.hearstapps.com/sev.h-cdn.co/assets/16/20/1024x786/gallery-1463667355-screen-shot-2016-05-19-at-101549-am.png?resize=1200:*', 'Had the best time meeting fans at the event today!', '2024-05-18 16:45:00'),
    (2, 'https://people.com/thmb/CNG1IqM_N4l-piqxiZA9KoI7jmo=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(815x154:817x156):format(webp)/selena-gomez-photo-dump-instagram-030624_2023-b904a87b58ae48759d4c9a6f2ae72f0c.jpg', 'The creative process is everything. Stay inspired!', '2024-05-20 20:00:00'),
    (2, 'https://people.com/thmb/CNG1IqM_N4l-piqxiZA9KoI7jmo=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(815x154:817x156):format(webp)/selena-gomez-photo-dump-instagram-030624_2023-b904a87b58ae48759d4c9a6f2ae72f0c.jpg', 'Chillin’ at home with my fur babies 🐾.', '2024-05-22 11:00:00'),

    (3, 'https://hips.hearstapps.com/hmg-prod/images/sbc-190506-a1-ss19-pb-djprojectrock-s04-1346-redheadphones-3-1562610745.jpg?resize=1200:*', 'Pushing my limits in the gym today. #IronParadise', '2024-06-21 18:45:00'),
    (3, 'https://people.com/thmb/-s6Sds6oItJFn_jcuec2oj4bHTY=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(719x0:721x2):format(webp)/the-rock-1-8f7b02c92ff84833b6c6a82265449d5b.jpg', 'Late-night meal prep. Fuel the body right!', '2024-06-23 22:00:00'),
    (3, 'https://people.com/thmb/6-mbqgQrjP-SWvGrz5dROOyMfJ8=/4000x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(574x0:576x2):format(webp)/dwayne-johnson-the-rock-moana-112124-2-a190054a4f6341a6b39858829ab0fcb4.jpg', 'Filming some intense action scenes today!', '2024-06-25 12:30:00'),
    (3, 'https://www.usanetwork.com/sites/usablog/files/styles/hero_image__large__computer__alt_1_5x/public/2023/05/wwe-the-rock-mental-health3.jpg', 'Reflecting on the journey. Stay hungry, stay humble.', '2024-06-27 19:15:00'),
    (3, 'https://people.com/thmb/sNOQ_-s0sR7j1Qo5PlLw1Fjcrlc=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(299x0:301x2):format(webp)/the-rock-pancakes-505a746c1cf94b9d8823b69a777b1949.jpg', 'Epic cheat meal incoming. Life’s about balance.', '2024-06-29 21:00:00'),

    (4, 'https://www.rollingstone.com/wp-content/uploads/2018/06/rs-ariana-grande-fans-9494e4ac-87a9-45e2-a3a0-9526a557ce9a.jpg?w=1500&h=1000&crop=1', 'Love you guys so much! Thanks for all the support on the new album!', '2024-08-03 15:25:00'),
    (4, 'https://thehighlandernews.com/wp-content/uploads/2018/12/thank-u-next-video.jpg', 'Spending some downtime with my favorite books.', '2024-08-05 11:00:00'),
    (4, 'https://assets.teenvogue.com/photos/5d1ba86924ce8a00080b5ffa/16:9/w_2240,c_limit/00-story-ariana-grande.jpg', 'Rehearsals are in full swing! Can’t wait for the tour!', '2024-08-07 17:10:00'),
    (4, 'https://ichef.bbci.co.uk/ace/standard/976/cpsprodpb/F679/production/_100379036_ariana_getty.jpg.webp', 'So grateful for the love and positivity from my fans.', '2023-08-09 14:45:00'),
    (4, 'https://i.pinimg.com/736x/8d/aa/d6/8daad6c8a1566f9991381de92c38880b.jpg', 'Baking some cookies today. Who wants one? 🍪', '2023-08-11 16:20:00'),

    (5, 'https://metro.co.uk/wp-content/uploads/2019/11/PRI_97571628.jpg?quality=90&strip=all&w=646', 'Surfing in Australia! Nothing like the waves back home.', '2024-09-10 11:00:00'),
    (5, 'https://cdn.centr.com/content/32000/31055/images/landscapewidedesktop2x-ch-workout-routine-to-build-inline-1a-169-08-119536-a-edit.jpg', 'Training hard for my next role. Feeling strong!', '2024-09-12 09:15:00'),
    (5, 'https://www.hola.com/us/horizon/original_aspect_ratio/f4a6e929bd68-chris-hemsworth.jpg?im=Resize=(960),type=downsize', 'Spending time with family is everything to me.', '2024-09-14 17:00:00'),
    (5, 'https://lumiere-a.akamaihd.net/v1/images/memory_105_limitless_cp11613_r_a0c041c9.jpeg?region=0%2C104%2C2000%2C1125', 'Nature is the best therapy. Take a hike!', '2024-09-16 08:30:00'),
    (5, 'https://www.koimoi.com/wp-content/new-galleries/2020/12/chris-hemsworth-great-to-be-back-on-set-0001.jpg', 'Grateful for the opportunities this year has brought.', '2024-09-18 20:45:00');
INSERT INTO friendships (source_id, target_id, created_at, status)
VALUES
    (1, 2, '2024-02-20', 'ACCEPTED'), -- Will Smith is friends with Selena Gomez
    (1, 3, '2024-04-15', 'ACCEPTED'), -- Will Smith is friends with The Rock
    (2, 4, '2024-05-10', 'ACCEPTED'), -- Selena Gomez is friends with Ariana Grande
    (3, 5, '2024-06-21', 'ACCEPTED'), -- The Rock is friends with Chris Hemsworth
    (4, 5, '2024-08-10', 'ACCEPTED'); -- Ariana Grande is friends with Chris Hemsworth