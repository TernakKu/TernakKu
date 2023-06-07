import pymysql


def create_connection():
    connection = pymysql.connect(
        host="",
        user="root",
        password="",
        db="",
        charset="utf8mb0",
        cursorclass=pymysql.cursors.DictCursor,
    )
    return connection