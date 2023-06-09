openapi: 3.0.3 info: title: Ternakku - OpenAPI 3.0 description: \|- The
API Documentation for Ternakku API part of Bangkit Capstone Project 2023
contact: email: ceoternakku@gmail.com version: 1.0.0 servers: - url:
https://ternakku-api-dy4c5fd5sa-et.a.run.app

components: securitySchemes: BearerAuth: type: http scheme: bearer
bearerFormat: JWT

paths: /authentication/register: post: summary: Register New User
description: register new user with data in body request requestBody:
description: data for register content: multipart/form-data: schema:
type: object properties: name: type: string email: type: string
password: type: string required: true responses: '200': description: OK
content: application/json: schema: type: object properties: error: type:
string enum: - "false" message: type: string enum: - "User Created"
'400': description: Invalid Data content: application/json: schema:
type: object properties: error: type: string enum: - "true" message:
type: string enum: - "Registration failed"

/authentication/login: post: summary: Login API description: Login
Feature requestBody: description: data for login content:
multipart/form-data: schema: type: object properties: email: type:
string password: type: string required: true responses: '200':
description: OK content: application/json: schema: type: object
properties: error: type: string enum: - "false" loginResult: type:
object properties: name: type: string

                      token:
                        type: string
                        
                      userId:
                        type: string
                        
                  message:
                    type: string
                    enum:
                      - "success"
        '400':
          description: Invalid Data
          content:
            application/json:
              schema:
                type: object
                properties:
                  error:
                    type: string
                    enum:
                      - "true"
                  message:
                    type: string
                    enum:
                      - "Login failed"
                      

/predict: post: summary: Predict Disease API description: main feature
that user post a image to predict disease for their livestock
security: - BearerAuth: \[\] requestBody: description: image for Machine
Learning model content: multipart/form-data: schema: type: object
properties: image: type: string format: binary required: true responses:
'200': description: OK content: application/json: schema: type: object
properties: disease_details: type: string disease_name: type: string
handling_method: type: string image_name: type: string original_image:
type: string userId: type: string

        '400':
          description: Invalid Data
          content:
            application/json:
              schema:
                type: object
                properties:
                  message:
                    type: string
                    enum:
                      - "Invalid data or key"
        
        '401':
          description: Unauthorized
          content:
            application/json:
              schema:
                type: object
                properties:
                  error:
                    type: string
                    enum:
                      - "Unauthorized"
     

/diseases: get: description: to get all diseases data responses: '200':
description: OK content: application/json: schema: type: object
properties: diseases: type: array items: type: object properties:
disease_details: type: string disease_name: type: string
handling_method: type: string

/get_user_history/`<userId>`{=html}: get: description: to get history by
userId responses: '200': description: OK content: application/json:
schema: type: object properties: history: type: array items: type:
object properties: disease_details: type: string disease_name: type:
string handling_method: type: string

                        timestamp:
                          type: string
        
        '404':
          description: userId not found
          content:
            application/json:
              schema:
                type: object
                properties:
                  history:
                    type: string
                    enum:
                      - []
                      
        '401':
          description: Unauthorized
          content:
            application/json:
              schema:
                type: object
                properties:
                  error:
                    type: string
                    enum:
                      - "Unauthorized"
