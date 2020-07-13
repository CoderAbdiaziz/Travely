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
An app where the user can select a point on a map and then be taken to a view of all of the best spots in the selected area. Once a spot is double tapped, it will be saved into your favorites to view later. Users can also find discounted flights and hotels in the areas selected. Users will be able to navigate between the map, personalized favorites, flights, and hotels.


### App Evaluation
[Evaluation of your app across the following attributes]
- **Category: Lifestyle**
- **Mobile: This app is great on a phone since you are always on the go while traveling. Having it on your phone is much more accessible rather than on a computer**
- **Story: Organizes all of the information a person needs/wants in a single place for them to fulfill their dreams and goals of traveling**
- **Market: Anybody who wants to travel or go on vacation. Schools and clubs can even use the app for field trips or convention trips**
- **Habit: Users will love to just hop on the app just to scroll through cool looking places or keep an eye on flight/hotel prices**
- **Scope:**

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User must be able to login/create an account
* The place chosen from the map must bring you to a page filled with different places travelers would like to go to.
* Must be an option to favorite places and be able to look at a list of all favorites
    * Should be able to remove places from favorites as well
* Zoom in animation when map is clicked into the designated spot which was click
* Places must show user ratings from the google API
* ...

**Optional Nice-to-have Stories**

* Sync accounts with google accounts
    * Account will show at the top right with their profile picture they set as well
* Users can customize the accounts they made in the app
* ...

### 2. Screen Archetypes

* Login Screen
   * User must be able to login/create an account
   * ...
* The map
   * User is able to click the map and have a zoomin animation into the designated spot which was clicked
* A listview of pictures in the area you selected
    * The place chosen from the map must bring you to a page filled with different places travelers would like to go to.
* Places details page
    * Places must show user ratings from the google API
* Favorites Page
    * User must be able to double tap a place in order to favorite it
* Flight
    * Pulls from a travel flight api to pull prices for selected places
* Hotel
    * Pulls from a hotel api to pull prices and availability for a selected location


### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home(The Map)
* Flight
* Hotel
* Favorites
* Account

**Flow Navigation** (Screen to Screen)

* [list first screen here]
   * [list screen navigation here]
   * ...
* [list second screen here]
   * [list screen navigation here]
   * ...

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="YOUR_WIREFRAME_IMAGE_URL" width=600>

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
