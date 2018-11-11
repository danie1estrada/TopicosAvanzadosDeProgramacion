DROP DATABASE IF EXISTS wow;
CREATE DATABASE wow;
USE wow;

CREATE TABLE GameCharacter (
    ID INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Name TEXT,
    Gender TEXT,
    Class TEXT,
    Faction TEXT,
    Race TEXT,
    CapitalCity TEXT
);

INSERT INTO GameCharacter VALUES (NULL, 'Sylvannas Windrunner', 'Female', 'Dark Ranger', 'Horde', 'Undead', 'Undercity');
INSERT INTO GameCharacter VALUES (NULL, 'Varok Saurfang', 'Male', 'Warrior', 'Horde', 'Orc', 'Orgrimmar');
INSERT INTO GameCharacter VALUES (NULL, 'Lady Liadrin', 'Female', 'Paladin', 'Horde', 'Blood Elf', 'Silvermoon');
INSERT INTO GameCharacter VALUES (NULL, 'Aunduin Wrynn', 'Male', 'Priest', 'Alliance', 'Human', 'Stormwind');
INSERT INTO GameCharacter VALUES (NULL, 'Tyrande Whisperwind', 'Female', 'Priest', 'Alliance', 'Night Elf', 'Darnassus');
INSERT INTO GameCharacter VALUES (NULL, 'Genn Greymane', 'Male', 'Warrior', 'Alliance', 'Worgen', 'Gilneas');
INSERT INTO GameCharacter VALUES (NULL, 'Jaina Proudmoore', 'Female', 'Mage', 'Alliance', 'Human', 'Kul Tiras');

SELECT * FROM GameCharacter;