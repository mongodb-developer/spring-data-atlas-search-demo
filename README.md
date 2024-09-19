# Notice: Repository Deprecation
This repository is deprecated and no longer actively maintained. It contains outdated code examples or practices that do not align with current MongoDB best practices. While the repository remains accessible for reference purposes, we strongly discourage its use in production environments.
Users should be aware that this repository will not receive any further updates, bug fixes, or security patches. This code may expose you to security vulnerabilities, compatibility issues with current MongoDB versions, and potential performance problems. Any implementation based on this repository is at the user's own risk.
For up-to-date resources, please refer to the [MongoDB Developer Center](https://mongodb.com/developer).

# Atlas search - Spring demo

This is a minimal Spring Boot application that demonstrates how 
to use Atlas search with MongoDB.
It relies on the popular spring boot mongodb integration, 
implementing a simple repository and service to fetch full text 
search results from a MongoDB collection and map them to POJOs.

## Getting started
1. Clone this repository to your favorite IDE.
2. Set up a free tier cluster on MongoDB Atlas. Sign up for an account 
   and create a cluster following the instructions in the 
   [official documentation](https://docs.atlas.mongodb.com/getting-started/).
3. Create the database user that you will use to connect to the cluster. 
   You can do this by following the instructions in the 
   [official documentation](https://docs.atlas.mongodb.com/security-add-mongodb-users/).
4. Load the sample data from sample_data.json into your cluster. You can
do this either through MongoDB compass, mongodb shell, or the mongoimport
utility. Install the mongoimport utility if you haven't already by following
the instructions in the [official documentation](https://docs.mongodb.com/database-tools/installation/installation/).
Get the connection string to your cluster by clicking on the "Connect" button of your cluster
in atlas and selecting "Connect your application". You will need the connection string
in two places - your import utility/compass and your application.properties file.
Edit src/main/resources/application.properties and replace the value of spring.data.mongodb.uri
5Import the data into your cluster using the mongoimport utility. 
   You can do this by running the following command in the terminal:
   ```bash
   mongoimport --uri "<your-connection-string>" -c users -d cashfocus -f ./sample_data/users.json
   ```
5. Create an Atlas search index on the users collection. You can do this by following the instructions in the 
   [official documentation](https://docs.atlas.mongodb.com/reference/atlas-search/create-index/). The easiest
way to do so is navigating to your cluster on atlas, clicking on the "Atlas Search" tab, and following the instructions.
6. Run the application (com.mongodb.demo.AtlasSpringApplication)
7. You can now access the application at http://localhost:8080. You can import
`postman_collection.json` for some example requests.

## Note on the mock data
Any resemblance to real persons or companies is purely coincidental. The data was generated
using the FakerJS library and is not real.
