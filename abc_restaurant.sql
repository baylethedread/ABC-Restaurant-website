-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 27, 2024 at 04:37 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `abc_restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Fast Foods'),
(2, 'Lunch Specials'),
(4, 'drinks'),
(5, 'Desserts'),
(6, 'test'),
(7, 'aaa'),
(8, 'test2'),
(9, 'ice creams'),
(10, 'testtest'),
(11, 'testtest'),
(12, 'Apples'),
(13, 'Dinner Specials'),
(14, 'Chilli Foods');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` blob DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `category_id`, `description`, `image`, `image_path`) VALUES
(6, 'Shawarma', 900, 1, 'with crispy chicken', NULL, 'src/images/Shawarma.jpg'),
(7, 'Burger', 600, 1, 'available in beef and chicken', NULL, 'src/images/Beetroot-Burger.jpg'),
(8, 'Kottu', 1500, 13, 'Availbale in fish, chicken and beef', NULL, 'src/images/79bfe7e4839440be81bba08b49b9bb9d.jpg'),
(9, 'Biriyani', 2000, 2, 'best biriyani in the market', NULL, 'src/images/ChickenBiryani.jpg'),
(10, 'Fried Rice', 1500, 2, 'Available in chicken and beef', NULL, 'src/images/Egg-fried-rice-2__FocusFillWyIwLjAwIiwiMC4wMCIsMTIwMCw2Mjhd.jpg'),
(11, 'Sandwich', 300, 1, 'Cheese and pepper', NULL, 'src/images/91afe3a3615aaa162847dc3fdcdda2da.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE `reservations` (
  `id` bigint(20) NOT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `query` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `members` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`id`, `customer_name`, `date`, `query`, `time`, `status`, `members`) VALUES
(1, 'test', '2024-09-12', 'aaaaaaaaaaaaa', '20:19', 'Confirmed', NULL),
(2, 'test', '2024-09-20', 'bbbbbbbbbb', '08:54', 'Canceled', NULL),
(4, 'test1', '2024-09-07', 'need a clean table with 5 chairs. put a flower vase on the table', '12:20', 'Pending', NULL),
(5, 'test1', '2024-09-21', 'add welcome juice on the table ', '15:35', 'Canceled', NULL),
(6, 'test', '2024-09-29', 'need a flower vase and two mojitos on the table before arrive', '11:00', 'Confirmed', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `usertype` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `username`, `usertype`) VALUES
(1, 'test@gmail.com', '123456', 'test', NULL),
(2, 'test1@gmail.com', '123456', 'test1', NULL),
(3, 'test3@gmail.com', '123456', 'test3', 'customer'),
(5, 'jean@gmail.com', '123456', 'jean', 'customer'),
(7, 'admin@gmail.com', '123456', 'admin', 'Admin'),
(8, 'staff@gmail.com', '123456', 'staff', 'Staff'),
(10, 'staff3@gmail.com', '123456', 'staff3', 'Staff'),
(13, 'sttttt@gmail.com', '123456', 'sttttt', 'Staff'),
(14, 'bbb@gmail.com', '123456', 'bbbb', 'Staff'),
(15, 'aiz@gmail.com', '123456', 'aiz', 'customer'),
(16, 'test5@gmail.com', '123456', 'test5', 'customer'),
(17, 'Jhon@gmail.com', '654321', 'Jhone Dow', 'customer'),
(18, 'tharaka@gmail.com', 'tharaka123', 'Tharaka', 'Staff'),
(19, 'tharaka@gmail.com', 'tharaka123', 'Tharaka', 'Staff');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`);

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
