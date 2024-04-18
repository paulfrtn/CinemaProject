-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Apr 18, 2024 at 07:02 PM
-- Server version: 8.0.19
-- PHP Version: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Cinema`
--

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `film_id` int NOT NULL,
  `film_title` varchar(255) NOT NULL,
  `film_director` varchar(255) NOT NULL,
  `film_genre` varchar(255) NOT NULL,
  `film_synopsis` longtext NOT NULL,
  `film_duration` int NOT NULL,
  `film_release_date` date NOT NULL,
  `film_status` tinyint(1) NOT NULL,
  `film_poster` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`film_id`, `film_title`, `film_director`, `film_genre`, `film_synopsis`, `film_duration`, `film_release_date`, `film_status`, `film_poster`) VALUES
(1, 'Le voyage de Chihiro', 'Hayao Miyazaki', 'Fantasy', 'Au cours d\'un voyage en voiture, la famille de Chihiro,10 ans, fait une halte dans un parc à thème qui semble abandonné. Ses parents découvrent des mets succulents dans un restaurant et commencent à manger. Ils se retrouvent alors transformés en cochons. Prise de panique, Chihiro s\'enfuit et rencontre l\'énigmatique Haku, qui lui explique le fonctionnement de l\'univers dans lequel elle vient de pénétrer. Pour sauver ses parents, la fillette va devoir faire face à la terrible sorcière Yubaba.', 125, '2002-04-14', 0, 'src/Model/Images/Chihiro.jpg'),
(2, 'Dune: Deuxième partie', 'Denis Villeneuve', 'SF', 'Paul Atréides se rallie à Chani et aux Fremen tout en préparant sa revanche contre ceux qui ont détruit sa famille. Alors qu\'il doit faire un choix entre l\'amour de sa vie et le destin de la galaxie, il devra néanmoins tout faire pour empêcher un terrible futur que lui seul peut prédire.', 166, '2024-02-28', 0, 'src/Model/Images/Dune2.jpg'),
(3, 'Joker: Folie à Deux', 'Todd Phillips', 'Crime', 'Arthur Fleck n\'est plus seul. Le voilà entraîné dans une folie à deux. Plus que jamais, le monde est une comédie.', 122, '2024-10-02', 2, 'src/Model/Images/Joker2.jpg'),
(4, 'Back to Black', ' Sam Taylor-Johnson', 'Musical', 'Retour sur la vie et la musique d\'Amy Winehouse, à travers la création de l\'un des albums les plus iconiques de la musique contemporaine, inspiré par son histoire d\'amour passionnée et tourmentée avec Blake Fielder-Civil.', 122, '2024-04-24', 1, 'src/Model/Images/B2B.jpg'),
(5, 'The Fall Guy', 'David Leitch', 'Action', 'Comme tous les cascadeurs, Colt Seavers se fait tirer dessus, exploser, écraser, jeter par les fenêtres et tombe toujours de plus haut, pour le plus grand plaisir du public. Un an après un accident qui a failli mettre fin à sa carrière, Colt est engagé sur le film de Jody Moreno, son ex-petite amie, pour servir de doublure à Tom Ryder, un célèbre acteur. Quand la star disparaît, Colt se porte volontaire pour le retrouver, espérant sauver le film et reconquérir Jody par la même occasion.', 125, '2024-05-01', 1, 'src/Model/Images/TFG.jpg'),
(6, 'Pulp Fiction', 'Quentin Tarantino', 'Crime/Thriller', ' L\'odyssée sanglante et burlesque de petits malfrats dans la jungle de Hollywood à travers trois histoires qui s\'entremêlent.', 154, '1994-10-26', 0, 'src/Model/Images/PF.jpg'),
(7, 'Deadpool & Wolverine', 'Shawn Levy', 'Super-héros', 'Wolverine se remet de ses blessures lorsqu\'il croise le chemin de la grande gueule, Deadpool, qui a voyagé dans le temps pour le soigner dans l\'espoir de devenir amis et de faire équipe pour vaincre un ennemi commun.', 130, '2024-07-24', 2, 'src/Model/Images/DP3.jpg'),
(8, 'La Planète des Singes : Le nouveau royaume', 'Wes Ball', 'Action', '300 ans après la mort de César, plusieurs camps de primates vivent dans le havre de paix, tandis que les humains ont régressé à l\'état sauvage à l\'extérieur de leur territoire. Alors que certains clans ont corrompu et dogmatisé l\'enseignement de César, un nouveau chef tente d\'unifier les différents camps grâce à la technologie humaine. En parallèle, Noa, un singe qui a fui l\'esclavage, rencontre une humaine.', 145, '2024-05-22', 2, 'src/Model/Images/LPDS.jpg'),
(9, 'Spy × Family Code: White', 'Takashi Katagiri', 'Action/Comédie', 'Après avoir été averti qu\'il serait remplacé dans l\'Opération Strix, Loid décide d\'aider Anya à remporter un concours de cuisine à l\'Eden Academy en préparant le repas préféré du directeur afin d\'empêcher son remplacement. Les Forger décident donc de se rendre dans la région d\'origine du plat, où ils déclenchent une chaîne d\'actions qui pourraient potentiellement mettre en danger la paix dans le monde.', 110, '2024-04-17', 0, 'src/Model/Images/SpyXFamily_CodeWhite.jpg'),
(10, 'Kung Fu Panda 4', 'Mike Mitchell', 'Comédie', 'Après trois aventures dans lesquelles le guerrier dragon Po a combattu les maîtres du mal les plus redoutables grâce à un courage et des compétences en arts martiaux inégalés, le destin va de nouveau frapper à sa porte pour l\'inviter à enfin se reposer. Plus précisément, pour être nommé chef spirituel de la vallée de la Paix.', 94, '2024-03-27', 0, 'src/Model/Images/KFP4.jpg'),
(11, 'Dune', 'Denis Villeneuve', 'SF', 'Paul Atreides, un jeune homme brillant et doué au destin plus grand que lui-même, doit se rendre sur la planète la plus dangereuse de l\'univers afin d\'assurer l\'avenir de sa famille et de son peuple.', 155, '2021-09-15', 0, 'src/Model/Images/Dune1.jpg'),
(12, 'Une vie', 'James Hawes', 'Guerre', 'À Prague, en 1938, alors que la ville est sur le point de tomber aux mains des nazis, un banquier londonien va tout mettre en oeuvre pour sauver des centaines d\'enfants promis à une mort certaine dans les camps de concentration.', 110, '2024-02-21', 0, 'src/Model/Images/1vie.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `offer`
--

CREATE TABLE `offer` (
  `offer_id` int NOT NULL,
  `offer_name` varchar(50) NOT NULL,
  `offer_description` varchar(255) NOT NULL,
  `offer_start_date` date NOT NULL,
  `offer_end_date` date NOT NULL,
  `offer_price` float DEFAULT NULL,
  `offer_discount` float DEFAULT NULL,
  `offer_limit` int DEFAULT NULL,
  `offer_user_type` int NOT NULL,
  `offer_status` tinyint(1) NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `offer`
--

INSERT INTO `offer` (`offer_id`, `offer_name`, `offer_description`, `offer_start_date`, `offer_end_date`, `offer_price`, `offer_discount`, `offer_limit`, `offer_user_type`, `offer_status`, `user_id`) VALUES
(1, 'Offre de Pâques', 'Offre de Pâques🐰: Cette saison des fêtes, offrez-vous une expérience cinématographique inoubliable avec notre promotion de Pâques !\r\n\r\n🎥 Profitez de films incontournables pour seulement 8€ le billet !', '2024-04-01', '2024-04-30', 8, NULL, NULL, 2, 1, 5),
(2, 'Offre spéciale jeune', 'Profitez de 2 billets pour le prix d\'1 durant tout le mois d\'avril.', '2024-04-01', '2024-04-30', NULL, 8, NULL, 1, 1, 5),
(3, 'Réduction exceptionnelle pour nos séniors', '-15% sur tous vos billets de cinéma pendant le mois d\'Avril.', '2024-04-01', '2024-04-30', NULL, 1.5, NULL, 3, 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `projetter`
--

CREATE TABLE `projetter` (
  `film_id` int NOT NULL,
  `salle_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `recevoir`
--

CREATE TABLE `recevoir` (
  `user_id` int NOT NULL,
  `offer_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

CREATE TABLE `salle` (
  `salle_id` int NOT NULL,
  `salle_number` int NOT NULL,
  `salle_capa_max` int NOT NULL,
  `salle_dispo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `salle`
--

INSERT INTO `salle` (`salle_id`, `salle_number`, `salle_capa_max`, `salle_dispo`) VALUES
(11, 1, 300, 0),
(12, 2, 300, 0),
(13, 3, 300, 0),
(14, 4, 200, 0),
(15, 5, 200, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Seance`
--

CREATE TABLE `Seance` (
  `seance_id` int NOT NULL,
  `seance_date` date NOT NULL,
  `seance_time` time NOT NULL,
  `seance_language` varchar(255) NOT NULL,
  `seance_nb_reservation` int NOT NULL,
  `film_id` int NOT NULL,
  `salle_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Seance`
--

INSERT INTO `Seance` (`seance_id`, `seance_date`, `seance_time`, `seance_language`, `seance_nb_reservation`, `film_id`, `salle_id`) VALUES
(1, '2024-04-24', '17:00:00', 'Vostfr', 0, 2, 11),
(2, '2024-04-24', '19:00:00', 'Vostfr', 0, 1, 14),
(3, '2024-04-27', '20:15:00', 'Vostfr', 0, 5, 11),
(4, '2024-04-25', '14:22:00', 'VF', 0, 10, 15),
(5, '2024-04-25', '18:00:00', 'Vostfr', 0, 2, 11),
(6, '2024-04-25', '17:00:00', 'Vostfr', 0, 9, 13);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticket_id` int NOT NULL,
  `ticket_date` date NOT NULL,
  `ticket_status` tinyint(1) NOT NULL,
  `ticket_price` float NOT NULL,
  `user_id` int DEFAULT NULL,
  `seance_id` int NOT NULL,
  `offer_id` int DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`ticket_id`, `ticket_date`, `ticket_status`, `ticket_price`, `user_id`, `seance_id`, `offer_id`, `mail`) VALUES
(1, '2024-04-27', 1, 12, 2, 3, NULL, NULL),
(2, '2024-04-24', 1, 12, NULL, 6, NULL, 'invite@gmail.com'),
(3, '2024-04-25', 1, 8, 1, 2, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `user_firstname` varchar(255) NOT NULL,
  `user_lastname` varchar(255) NOT NULL,
  `user_mail` varchar(255) NOT NULL,
  `user_pseudo` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_birthday` date NOT NULL,
  `user_role` tinyint(1) NOT NULL,
  `user_type` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_firstname`, `user_lastname`, `user_mail`, `user_pseudo`, `user_password`, `user_birthday`, `user_role`, `user_type`) VALUES
(1, 'Lily', 'Wunsch', 'lily.wunsch@edu.ece.fr', 'Leelee', 'KzPLB+fsTcguYXulcdxG3ISHwKsu5r37rcz5Foc2Tec=', '2003-11-28', 0, 2),
(2, 'Paul', 'Fortuna', 'paulalexandre.fortuna@edu.ece.fr', 'paulfrtn', 'ZxXM8NDlzIkdZOXemORdiB+8tvYaLBaNFP/FApyenzg=', '2002-08-17', 0, 2),
(3, 'JN', 'Neyret', 'jeannicolas.neyret@edu.ece.fr', 'ji3en', '6y7dxxKodS6lId+uNyF/04Kp1W7t64Kb0DdX52l0OTw=', '2002-04-01', 0, 3),
(4, 'Jules', 'Puget', 'jules.puget@edu.ece.fr', 'soulax', '85Xh/+ZPpKia0dMEtqKHNHxICu2u9gjmUJI3A1stTWE=', '2003-04-01', 0, 1),
(5, 'admin', 'cinéma', 'admin.cinema@cinemaece.fr', 'admin', '7l3zvh+9dzXl5PRfvvvJtldZ6wVYSpWNf5CCC2OSa9Q=', '2000-04-01', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`film_id`);

--
-- Indexes for table `offer`
--
ALTER TABLE `offer`
  ADD PRIMARY KEY (`offer_id`),
  ADD KEY `offer_user_FK` (`user_id`);

--
-- Indexes for table `projetter`
--
ALTER TABLE `projetter`
  ADD PRIMARY KEY (`film_id`,`salle_id`),
  ADD KEY `projetter_salle0_FK` (`salle_id`);

--
-- Indexes for table `recevoir`
--
ALTER TABLE `recevoir`
  ADD PRIMARY KEY (`user_id`,`offer_id`),
  ADD KEY `recevoir_offer0_FK` (`offer_id`);

--
-- Indexes for table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`salle_id`);

--
-- Indexes for table `Seance`
--
ALTER TABLE `Seance`
  ADD PRIMARY KEY (`seance_id`),
  ADD KEY `Seance_film_FK` (`film_id`),
  ADD KEY `Seance_salle0_FK` (`salle_id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_id`),
  ADD KEY `ticket_user_FK` (`user_id`),
  ADD KEY `ticket_Seance0_FK` (`seance_id`),
  ADD KEY `ticket_offer1_FK` (`offer_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `film_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `offer`
--
ALTER TABLE `offer`
  MODIFY `offer_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `salle`
--
ALTER TABLE `salle`
  MODIFY `salle_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `Seance`
--
ALTER TABLE `Seance`
  MODIFY `seance_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ticket_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `offer`
--
ALTER TABLE `offer`
  ADD CONSTRAINT `offer_user_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `projetter`
--
ALTER TABLE `projetter`
  ADD CONSTRAINT `projetter_film_FK` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`),
  ADD CONSTRAINT `projetter_salle0_FK` FOREIGN KEY (`salle_id`) REFERENCES `salle` (`salle_id`);

--
-- Constraints for table `recevoir`
--
ALTER TABLE `recevoir`
  ADD CONSTRAINT `recevoir_offer0_FK` FOREIGN KEY (`offer_id`) REFERENCES `offer` (`offer_id`),
  ADD CONSTRAINT `recevoir_user_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `Seance`
--
ALTER TABLE `Seance`
  ADD CONSTRAINT `Seance_film_FK` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`),
  ADD CONSTRAINT `Seance_salle0_FK` FOREIGN KEY (`salle_id`) REFERENCES `salle` (`salle_id`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_offer1_FK` FOREIGN KEY (`offer_id`) REFERENCES `offer` (`offer_id`),
  ADD CONSTRAINT `ticket_Seance0_FK` FOREIGN KEY (`seance_id`) REFERENCES `Seance` (`seance_id`),
  ADD CONSTRAINT `ticket_user_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
