CREATE TABLE IF NOT EXISTS user (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    username VARCHAR(45) NOT NULL,
    email VARCHAR(180) NOT NULL,
    password VARCHAR(300) NOT NULL,
    last_access DATETIME NOT NULL,
    become_user DATETIME NOT NULL,
    is_valid TINYINT NOT NULL,
    token VARCHAR(300)
);

CREATE TABLE IF NOT EXISTS relationship (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    following_user_id INT NOT NULL,
    CONSTRAINT fk_relationship_user FOREIGN KEY (user_id)
        REFERENCES user (id),
    CONSTRAINT fk_relationship_following_user FOREIGN KEY (following_user_id)
        REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS mediatype (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS post (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(120) NOT NULL,
    subtitle VARCHAR(320) NOT NULL,
    post_date DATETIME NOT NULL,
    mediatype_id INT NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT fk_post_user FOREIGN KEY (user_id)
        REFERENCES user (id),
    CONSTRAINT fk_post_media FOREIGN KEY (mediatype_id)
        REFERENCES mediatype (id)
);

ALTER TABLE post ADD(picture VARCHAR(200));