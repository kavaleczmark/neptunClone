-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Nov 23. 20:54
-- Kiszolgáló verziója: 10.4.28-MariaDB
-- PHP verzió: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `neptunclone`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `classroom`
--

CREATE TABLE `classroom` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `spaces` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `classroom`
--

INSERT INTO `classroom` (`id`, `name`, `spaces`) VALUES
(1, 'B.111', 100),
(2, 'B.113', 250);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `lecture`
--

CREATE TABLE `lecture` (
  `id` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `places` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `classroom_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `lecture`
--

INSERT INTO `lecture` (`id`, `time`, `places`, `teacher_id`, `classroom_id`, `subject_id`) VALUES
(1, 8, 100, 3, 2, 2);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `subject`
--

CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `subject`
--

INSERT INTO `subject` (`id`, `name`) VALUES
(1, 'BAI0168'),
(2, 'BAI0176'),
(3, 'BPI1116');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `teacher`
--

INSERT INTO `teacher` (`id`, `name`, `subject_id`) VALUES
(1, 'Frank Herbert', 1),
(2, 'Mary Shelley', 1),
(3, 'Kurt Vonnegut', 2),
(4, 'Andy Weir', 3);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `classroom`
--
ALTER TABLE `classroom`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `lecture`
--
ALTER TABLE `lecture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `classroom_id` (`classroom_id`),
  ADD KEY `teacher_id` (`teacher_id`);

--
-- A tábla indexei `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `classroom`
--
ALTER TABLE `classroom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `lecture`
--
ALTER TABLE `lecture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT a táblához `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT a táblához `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `lecture`
--
ALTER TABLE `lecture`
  ADD CONSTRAINT `lecture_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `lecture_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `lecture_ibfk_3` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `lecture_ibfk_4` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `lecture_ibfk_5` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `lecture_ibfk_6` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`),
  ADD CONSTRAINT `lecture_ibfk_7` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
