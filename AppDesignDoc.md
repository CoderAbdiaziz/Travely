Original App Design Project - README Template
===

# Travely


## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
A traveling app! An app where the user can select a point on a map where they are currently or going to view all of the popular spots in the area selected. Douple tapping a selected area will favorite it and leave it for you to view later. You can even share your list with friends, or see their lists.



### App Evaluation
[Evaluation of your app across the following attributes]
- **Category: Lifestyle**
- **Mobile: This app is great on a phone since you are always on the go while traveling. Having it on your phone is much more accessible rather than on a computer. This is especially the case with communicating with friends and sharing lists on the go**
- **Story: Organizes all of the information a person needs/wants in a single place for them to fulfill their dreams and goals of traveling. You can even share these personalized lists with friends**
- **Market: Anybody who wants to travel or go on vacation. Schools and clubs can even use the app for field trips or convention trips**
- **Habit: Looking through comments and sharing locations with friends can become addicting. Users continously will want to come back and see what pictures their friends shared with them**
- **Scope: It will be a local storage of places within California. Users that want to find a place in california near them or accross the state. It can turn into a map of the country, then of the world. It can also potentially included a social media feel where you can meet others with similar lists.**

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* Users must be able to login/logout
* User must be able to create an account
* Clicking on the map should bring you to that specific city with a list(recycler view) of popular places in the vicinity
    * sorted by most popular (optional)
* Double tapping on a place should favorite it and should show up on your favorites page
    * some sort of toast saying "Added to Favorites"
    * able to remove places from your favorites list
* Tapping a place should give you details of that place
    * Pictures, rating, reviews, add a review(link it to google maps reviews)
* Zoom in animation once map point was clicked in
* Share your list or any specific location with a friend on Facebook

**Optional Nice-to-have Stories**

* Feed activity/fragment where it shows your friends photos they've posted
* You can look at your friends lists on their page
* customize user pages with facebook information
* a search option where you dont have to click the map and can go to a specific place right away



### 2. Screen Archetypes

* Login Screen
   * User must be able to login/create an account
* The map
   * User is able to click the map and have a zoomin animation into the designated spot which was clicked
* A listview of pictures in the area you selected
    * The place chosen from the map must bring you to a page filled with different places travelers would like to go to.
* Places details page
    * Places must show user ratings from the google API
* Favorites Page
    * User must be able to double tap a place in order to favorite it
    * Show all the places that have been favorited and can remove or share


### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home(The Map)
* Favorites
* Feed(Optional)
* Account

**Flow Navigation** (Screen to Screen)

* Intro screen
    * takes you to either login or signup based on what you click
* Login or Signin Screen
    * Takes you to the actual app now
* Map screen
    * Here you can click where you'd like to go on the map
    * takes you to a list of places
* Popular places screen
    * Takes you to place details page once a user clicks on a specific place
* Place details
    * From here you can either go back via the android back button or use the navigation view
    * using the navigation view will take you to either map, favorites, or account info  (can take you to feed if implimented)

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="Wireframe.jpg" width=600>
<img src="Login.jpg" width=300>
<img src="list.jpg" width=300>
<img src="map.jpg" width=300>
<img src="profile.jpg" width=300>
<img src="feed.jpg" width=300>
<img src="favorites.jpg" width=300>


### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
