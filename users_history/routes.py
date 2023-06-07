from flask import Blueprint, jsonify
from . import get_users_history
from disease_details import get_disease_details
from . import users_disease_history_bp


@users_disease_history_bp.route('/get_user_history/<userId>', methods=['GET'])
def user_history(userId):
    history = get_users_history(userId)
    
    if isinstance(history, str):
        return jsonify({'error': history}), 500
    
    updated_history = []
    for entry in history:
        if isinstance(entry, tuple):
            # ngantukkk tapi naggung Convert tuple ke dictionary
            entry_dict = {
                'disease_name': entry[0],
                'timestamp': entry[1],
                
            }
            predicted_class = entry[0]
        else:
            entry_dict = entry
            predicted_class = entry.get('disease_name')
        
        if predicted_class:
            disease_details, handling_method = get_disease_details(predicted_class)
            entry_dict['disease_details'] = disease_details
            entry_dict['handling_method'] = handling_method
        
        updated_history.append(entry_dict)
    
    return jsonify({'history': updated_history}), 200
