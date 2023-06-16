<p align="center"> 
  </a>
  <h1 align="center">
  Back-End for TernakKu Application</h1>
</p>

# TernakKu-API
<p align="justify">
    <a>This repository contains the code for a RESTful API developed using Python and Flask as the framework. The API is designed to provide various features related to disease detection on chicken and cow. It has been deployed on Google Cloud Run, making it highly scalable and easy to manage. The API utilizes machine learning models to process images uploaded through a POST request and generates results based on the analysis. Python with Flask was chosen for its flexibility in API development, allowing us to easily implement the required functionalities.<br><br>
To ensure secure authentication and user data storage, we have integrated Firebase into our API. Firebase provides robust authentication features, allowing users to register and log in securely. For data storage, we have employed Google Cloud services. Cloud Storage is utilized to store images with high reliability, softness, and scalability. Our database consists of two components: Cloud SQL for storing scan history data and disease information, providing efficient querying capabilities. We leverage the relational database capabilities of Cloud SQL to ensure data consistency and integrity. </a>
</p>

![image](https://github.com/TernakKu/TernakKu-Bangkit-2023-Product-Capstone/assets/121289117/8a5e8c58-ccbe-4909-ab53-32747b0679aa)


![Cloud Architecture2](https://github.com/TernakKu/TernakKu-Bangkit-2023-Product-Capstone/assets/121289117/09bd5ee2-55f1-4075-826b-583e0303d48a)


# How to Use
- Clone this Repository
- Run on terminal ``` pip install requirements.txt ```
- Run on terminal ``` python app.py ```
- Local Host: Run with python, local IP and Port:5000
  `http://127.0.0.1:5000/` or `http://localhost:5000/
# Endpoint Route

- ## Register
#### POST ```authentication/register```

#### Body [ Form Data ]

| Key      | Type   | Default | Required | Description      |
| -------- | ------ | ------- | -------- | ---------------- |
| ```name```     | Text |         | Yes      | Name of the user |
| ```email```   | Text |         | Yes      | User email       |
| ```password``` | Text |         | Yes      | User password    |

#### Successful response

> Success (201)
>
> ```JSON
> {
>    "error": false,
>    "message": "User Created"
> }
> ```

#### Failed response

> Registration failed (400)
>
> ```JSON
>{
>    "error": true,
>    "message": "Registration failed"
>}
> ```



- ## Login
#### POST ```authentication/login```

#### Body [ Form Data ]

| Key      | Type   | Default | Required | Description      |
| -------- | ------ | ------- | -------- | ---------------- |
| ```email```   | Text |         | Yes      | User email       |
| ```password``` | Text |         | Yes      | User password    |

#### Successful response

> Success (201)
>
> ```JSON
>{
>    "error": false,
>    "loginResult": {
>        "Name": "wahyu2",
>        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJYWGJlRmVLZHFGVzZxTEZaQkJ4Z1dlRTVYWGoyIiwibmFtZSI6IndhaHl1MiJ9.nHp-EWryH3HvRYkjZS8Tx_YDc0H3Zbj9n7->Dxj234zk",
>        "userId": "XXbeFeKdqFW6qLFZBBxgWeE5XXj2"
>    },
>    "message": "success"
}
> ```

#### Failed response

> Login failed (400)
>
> ```JSON
>{
>    "error": true,
>    "message": "Login failed"
>}
> ```


- ## Predict
#### POST ```/predict```
#### Header

| Name          | Type   | Default | Required | Value                             |
| ------------- | ------ | ------- | -------- | --------------------------------- |
| Authorization | Bearer |         | NO      | Auth token from register or login |

#### Body [ Form Data ]

| Key      | Type   | Default | Required | Description      |
| -------- | ------ | ------- | -------- | ---------------- |
| ```image```   | file |         | Yes      | image       |

#### Successful response

> Success (201)
>
> ```JSON
>{
>    "disease_details": "Penyakit sapi berbintik, juga dikenal sebagai Penyakit Kulit Berbintik Bovine (LSD), adalah penyakit viral yang mempengaruhi sapi. Penyakit ini >ditandai dengan demam, nodul kulit, dan pembengkakan.",
>    "disease_name": "Lumpy Cows",
>    "handling_method": "Untuk mengelola penyakit sapi berbintik, penting untuk mengisolasi hewan yang terinfeksi, menerapkan langkah pengendalian vektor, dan memberikan >perawatan suportif. Konsultasikan dengan dokter hewan untuk opsi pengobatan yang spesifik.",
>    "image_name": "image_20230616131734.jpeg",
>    "original_image": "https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230616131734.jpeg",
>    "userId": "sSXWk9e4NTYSjubQXn8Xu71nepj1"
>}
> ```

#### Failed response

> Failed to get the prediction (400)
>
> ```JSON
>{
>    "message": "Failed to get the prediction"
>}
> ```


- ## Get All Diseases
#### GET ```/diseases```
#### Header

| Name          | Type   | Default | Required | Value                             |
| ------------- | ------ | ------- | -------- | --------------------------------- |
| Authorization | Bearer |         | No      | Auth token from register or login |

#### Successful response

> Success (201)
>
> ```JSON
> {
>   "diseases": [
>       {
>            "disease_details": "Coccidiosis adalah penyakit parasit umum pada unggas yang disebabkan oleh protozoa dari genus Eimeria. Penyakit ini mempengaruhi saluran >pencernaan dan dapat menyebabkan diare, penurunan berat badan, dan penurunan produksi telur.",
>            "disease_name": "Cocciodiosis",
>            "handling_method": "Untuk mengelola Coccidiosis, penting untuk menjaga kebersihan yang baik di tempat pemeliharaan unggas, menyediakan air minum yang bersih, dan >menggunakan obat anticoccidial yang sesuai.",
>            "id": 1
>        },
>        {
>           "disease_details": "Ayam Anda terlihat sehat.",
>            "disease_name": "Healthy Chickens",
>            "handling_method": "Terus berikan nutrisi yang tepat, air bersih, dan jaga kebersihan yang baik untuk memastikan kesehatan mereka.",
>            "id": 2
>        },
>        {
>            "disease_details": "Sapi Anda terlihat sehat.",
>            "disease_name": "Healthy Cows",
>            "handling_method": "Terus berikan nutrisi yang tepat, air bersih, dan jaga kebersihan yang baik untuk memastikan kesehatan mereka.",
>            "id": 3
>        },
>        {
>            "disease_details": "Penyakit sapi berbintik, juga dikenal sebagai Penyakit Kulit Berbintik Bovine (LSD), adalah penyakit viral yang mempengaruhi sapi. Penyakit >ini ditandai dengan demam, nodul kulit, dan pembengkakan.",
>            "disease_name": "Lumpy Cows",
>            "handling_method": "Untuk mengelola penyakit sapi berbintik, penting untuk mengisolasi hewan yang terinfeksi, menerapkan langkah pengendalian vektor, dan >memberikan perawatan suportif. Konsultasikan dengan dokter hewan untuk opsi pengobatan yang spesifik.",
>            "id": 4
>        },
>        {
>            "disease_details": "Salmonella adalah infeksi bakteri yang dapat mempengaruhi unggas maupun ternak. Penyakit ini dapat menyebabkan diare, dehidrasi, dan dalam >kasus yang parah, kematian.",
>            "disease_name": "Salmonella",
>            "handling_method": "Untuk mengelola infeksi Salmonella, penting untuk menjaga kebersihan yang baik, menyediakan air minum yang bersih, dan menerapkan langkah >biosekuriti. Pemberian antibiotik yang sesuai mungkin diperlukan setelah berkonsultasi dengan dokter hewan.",
>            "id": 5
>        }
>    ]
>}
> ```



- ## Get Detail Diseases
#### GET ```details/Salmonella```
#### Header

| Name          | Type   | Default | Required | Value                             |
| ------------- | ------ | ------- | -------- | --------------------------------- |
| Authorization | Bearer |         | No      | Auth token from register or login |

#### Successful response

> Success (201)
>
> ```JSON
>{
>    "disease_details": "Salmonella adalah infeksi bakteri yang dapat mempengaruhi unggas maupun ternak. Penyakit ini dapat menyebabkan diare, dehidrasi, dan dalam kasus yang >parah, kematian.",
>    "disease_name": "Salmonella",
>    "handling_method": "Untuk mengelola infeksi Salmonella, penting untuk menjaga kebersihan yang baik, menyediakan air minum yang bersih, dan menerapkan langkah biosekuriti. >Pemberian antibiotik yang sesuai mungkin diperlukan setelah berkonsultasi dengan dokter hewan."
>}
> ```

#### Failed response

> Penyakit tidak diketahui (400)
>
> ```JSON
>{
>    "disease_details": [
>        "Penyakit tidak diketahui"
>    ],
>    "disease_name": "Salmonellaa",
>    "handling_method": "Silakan konsultasikan dengan dokter hewan untuk diagnosis dan pengobatan lebih lanjut."
>}
> ```



- ## Get Predict History by User Id
#### GET ```/get_user_history/<user id>```
#### Header

| Name          | Type   | Default | Required | Value                             |
| ------------- | ------ | ------- | -------- | --------------------------------- |
| Authorization | Bearer |         | No      | Auth token from register or login |

#### Successful response

> Success (201)
>
> ```JSON
>{
>    "History Predict": [
>        {
>            "disease_details": "Penyakit sapi berbintik, juga dikenal sebagai Penyakit Kulit Berbintik Bovine (LSD), adalah penyakit viral yang mempengaruhi sapi. Penyakit >ini ditandai dengan demam, nodul kulit, dan pembengkakan.",
>            "disease_name": "Lumpy Cows",
>            "handling_method": "Untuk mengelola penyakit sapi berbintik, penting untuk mengisolasi hewan yang terinfeksi, menerapkan langkah pengendalian vektor, dan >memberikan perawatan suportif. Konsultasikan dengan dokter hewan untuk opsi pengobatan yang spesifik.",
>            "id": 1,
>            "timestamp": "https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230616131734.jpeg"
>        },
>        {
>            "disease_details": "Sapi Anda terlihat sehat.",
>            "disease_name": "Healthy Cows",
>            "handling_method": "Terus berikan nutrisi yang tepat, air bersih, dan jaga kebersihan yang baik untuk memastikan kesehatan mereka.",
>            "id": 2,
>            "timestamp": "https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230616132753.jpeg"
>        }
>    ]
>}
> ```


---
<p align="center">
    <a href="https://github.com/TernakKu/TernakKu-Bangkit-2023-Product-Capstone/edit/main/Cloud%20Computing"> © C23-PS408 | Cloud Computing TernakKu Team </a>
</p>
