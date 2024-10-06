import numpy as np
import math

def calculate_relative_positions(landmarks):

    left_hip = landmarks[7]
    right_hip = landmarks[8]

    center_x = (left_hip[0] + right_hip[0]) / 2
    center_y = (left_hip[1] + right_hip[1]) / 2

    relative_positions = []
    for landmark in landmarks:
        rel_x = landmark[0] - center_x
        rel_y = landmark[1] - center_y
        relative_positions.append((rel_x / (math.sqrt(math.pow(rel_x, 2) + math.pow(rel_y, 2))), rel_y / math.sqrt(math.pow(rel_x, 2) + math.pow(rel_y, 2))))

    return relative_positions


def calculate_similarity(user_landmarks, target_landmarks):
    assert len(user_landmarks) == len(target_landmarks), "Landmark count mismatch."

    distances = []

    for user_landmark, target_landmark in zip(user_landmarks, target_landmarks):
        user_pos = np.array([user_landmark[0], user_landmark[1]])
        target_pos = np.array([target_landmark[0], target_landmark[1]])
        distance = np.linalg.norm(user_pos - target_pos)
        distances.append(distance)

    similarity_score = np.mean(distances)
    return similarity_score


