from flask import Blueprint, jsonify
from users.users import get_users_history

users_disease_history_bp = Blueprint('users_disease_history', __name__)

@users_disease_history_bp.route('/get_user_history/<userId>', methods=['GET'])
def user_history(userId):
    history = get_users_history(userId)
    
    if isinstance(history, str):
        return jsonify({'error': history}), 500
    
    return jsonify({'history': history}), 200 