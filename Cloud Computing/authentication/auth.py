from flask import request, jsonify
import jwt
secret_key = "eyJhbGciOiJIUzM4NCIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIyMjIyMjIyMjIyIiwibmFtZSI6IldhaHl1IFdhcmRhbmEiLCJpYXQiOiJURVJOQUtLVSJ9.3B9nLme7S1JrjXIgA_mWRF8AIzvfmisHu50mInqpPbNUz70hONUSYSQQMArmpw3Z"
def authenticate_token(func):
    def wrapper(*args, **kwargs):
        # request token
        auth_header = request.headers.get('Authorization')
        if not auth_header:
            return jsonify({'error': 'Unauthorized'}), 401

        try:
            # extract from bearer token
            token = auth_header.split(' ')[1]

            # Decode and verify  tken
            decoded_token = jwt.decode(token, secret_key, algorithms=['HS256'])
            request.user = decoded_token
        except jwt.ExpiredSignatureError:
            return jsonify({'error': 'Token expired'}), 403
        except jwt.InvalidTokenError:
            return jsonify({'error': 'Invalid token'}), 403

        return func(*args, **kwargs)

    return wrapper