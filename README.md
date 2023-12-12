# Android Streaming App

## Description

This Android Streaming App allows users to view a collection of movies, submit new movies, and manage their account. Users can browse movies in a grid view, view detailed information about each movie, and add new movies if they are signed in. The app integrates Firebase for data storage and user authentication.

## Features

- **Browse Movies**: Users can view a list of movies in a grid format.
- **Movie Details**: Clicking on a movie shows detailed information about it.
- **User Authentication**: Users can register and log in to access additional features.
- **Add Movies**: Signed-in users can submit new movies to the collection.

## How to Run the App

### Prerequisites

- Android Studio
- Firebase Project

### Setup

1. **Clone the Repository**: Clone this repository to your local machine or download the source code.
   
   ```
   git clone https://github.com/your-username/your-repo-name.git
   ```

2. **Open the Project in Android Studio**:
   - Open Android Studio.
   - Click on 'Open an Existing Project'.
   - Navigate to the cloned repository and open it.

3. **Connect to Firebase**:
   - Go to the [Firebase Console](https://console.firebase.google.com/).
   - Create a new Firebase project or use an existing one.
   - Connect your app to Firebase using the Firebase Assistant in Android Studio (Tools > Firebase).
   - Follow the steps to add Firebase Authentication and Firestore to your app.

4. **Run the App**:
   - Select an emulator or connect a physical device.
   - Click on the 'Run' button in Android Studio to build and run the app.

## How to Use the App

1. **Browse Movies**: On the main screen, users can view all movies listed in the grid view.

2. **View Movie Details**: Tap on any movie to view its detailed information, including title, description, and video content.

3. **User Registration and Login**:
   - New users can register by clicking the 'Register/Login' button and entering their email and password.
   - Existing users can log in using the same button.

4. **Add New Movies**:
   - Once logged in, users can add new movies by clicking the '+' button.
   - Enter the movie details in the form and submit.

5. **Sign Out**:
   - Users can sign out from the account options within the app.
