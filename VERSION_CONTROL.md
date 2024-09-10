# Version Control Documentation

## Project: ABC Restaurant Web Application

This document provides an overview of the version control strategies used throughout the development of the ABC Restaurant Web Application.

---

## Branching Strategy

We followed a simple **Git branching workflow**:

- **main**: The production-ready code branch.
- **feature branches**: Separate branches created for adding new features, fixing bugs, or making other updates.

### Workflow:
1. Create a feature branch:
    ```bash
    git checkout -b feature/<feature-name>
    ```

2. After the feature is developed, commit the changes:
    ```bash
    git add .
    git commit -m "Add feature: <description>"
    ```

3. Merge the feature branch back to `main` when it's ready:
    ```bash
    git checkout main
    git merge feature/<feature-name>
    ```

4. Push the changes to the remote repository:
    ```bash
    git push origin main
