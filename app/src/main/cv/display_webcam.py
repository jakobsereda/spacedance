import cv2
import mediapipe as mp
import time
from data_processing import calculate_relative_positions, calculate_similarity


def display_webcam():
    useful_landmark_ids = [0, 11, 12, 13, 14, 15, 16, 23, 24, 25, 26, 27, 28]
    target_landmarks = [(-0.014907338445422854, -0.9998888794563491), (0.2016220302197325, -0.9794634025475751), (-0.23788770774749302, -0.9712926636717912), (0.320652910501416, -0.947196764662428), (-0.337523728357502, -0.9413170203473702), (0.3528479912787513, -0.9356806586921365), (-0.34425591819629997, -0.9388758505717476), (0.9961380662238555, -0.08780064361835593), (-0.9961380662238555, 0.08780064361835593), (0.44847534648608456, 0.893795202266261), (-0.4769838000823672, 0.8789120857395148), (0.3664217918696345, 0.9304488542864923), (-0.42045305350108936, 0.9073142949395265)]
    cap = cv2.VideoCapture(0)
    if not cap.isOpened():
        print("Error: Could not open webcam.")
        return

    mp_drawing = mp.solutions.drawing_utils
    mp_pose = mp.solutions.pose
    pose = mp_pose.Pose(min_detection_confidence=0.5, min_tracking_confidence=0.5)

    start_time = time.time()

    while True:
        ret, frame = cap.read()
        if ret:
            frame = cv2.resize(frame, (540, 460))
            frame_rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
            pose_results = pose.process(frame_rgb)
            mp_drawing.draw_landmarks(frame, pose_results.pose_landmarks, mp_pose.POSE_CONNECTIONS)
            cv2.imshow('Webcam', frame)
            user_landmarks = []

            if pose_results.pose_landmarks:

                for id, landmark in enumerate(pose_results.pose_landmarks.landmark):
                    if id in useful_landmark_ids:
                        x = landmark.x
                        y = landmark.y
                        user_landmarks.append((x, y))
                        # print(f'Landmark {id}: (x: {x:.2f}, y: {y:.2f}')

                user_relative_positions = calculate_relative_positions(user_landmarks)
                # print(f"User relative positions: {user_relative_positions}")

                similarity_score = calculate_similarity(user_relative_positions, target_landmarks)

                print(f'Similarity score {similarity_score}')

            # Check if 7 seconds have passed
            elapsed_time = time.time() - start_time
            if elapsed_time > 7:
                print("7 seconds elapsed. Stopping the webcam.")
                break

        else:
            print("Error: Failed to capture frame.")
            break
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    cap.release()
    cv2.destroyAllWindows()


if __name__ == "__main__":
    display_webcam()

