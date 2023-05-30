# RESTFul API

Specification:

| Method | Path          | Response Code | Body | Description         |
| ------ |---------------| ------------- | ---- |---------------------|
| POST   | /predict     | 200 | JSON | Make prediction from uploaded image |
| GET    | /    | 200 | JSON | Status   |
| GET | /details/<disease>| 200 | JSON | disease Details     |

Prediction data structure:

```json
{
    "disease_details": "Salmonella adalah infeksi bakteri yang dapat mempengaruhi unggas maupun ternak. Penyakit ini dapat menyebabkan diare, dehidrasi, dan dalam kasus yang parah, kematian.",
    "handling_method": "Untuk mengelola infeksi Salmonella, penting untuk menjaga kebersihan yang baik, menyediakan air minum yang bersih, dan menerapkan langkah biosekuriti. Pemberian antibiotik yang sesuai mungkin diperlukan setelah berkonsultasi dengan dokter hewan.",
    "predicted_class": "Salmonella"
}
```
Server options:
 - `port`     : 5000
 - `host`     : 34.128.92.12
 - `protocol` : http


# Deployment using Compute Engine
Compute engine options:
- `Machine type` : e2-medium
- `Zone`         : asia-southeast2-a
- `Boot Disk`    : Debian GNU/Linux, 11 (bullseye), amd64 built on 20230509, supports Shielded VM feature
![image](https://github.com/TernakKu/TernakKu-Bangkit-2023-Product-Capstone/assets/134289835/12df73c6-3d8b-4ca0-bd4b-9ba095ef4536)


