#include <iostream>
#include "Task6.h"
#include "Student.h"
#include "Store.h"
#include "Checker.h"
using namespace std;

int main()
{
    Task6 obj;
    Store store;
    Checker c;
    bool temp = true;
    while (temp)
    {
        cout << "1.Division" << endl
             << "2.Add student details" << endl
             << "3.string index" << endl
             << "4.Array Index" << endl;
        int val;
        cin >> val;
        switch (val)
        {
        case 1:
        {
            cout << "Enter the value" << endl;
            int a;
            cin >> a;
            cout << "Enter the value" << endl;
            int b;
            cin >> b;
            try
            {
                int c = obj.division(a, b);
                cout << "The output is " << c;
            }
            catch (string s)
            {
                cout << s << endl;
            }
            break;
        }
        case 2:
        {
            cout << "Enter the name" << endl;
            string name;
            cin >> name;
            c.nameChecker(name);
            cout << "Enter the roll number" << endl;
            int roll;
            cin >> roll;
            cout << "Enter the age" << endl;
            int age;
            cin >> age;
            c.ageChecker(age);
            cout << "Enter the course" << endl;
            string course;
            cin >> course;
            c.courseChecker(course);
            Student sObj(roll, age, name, course);
            bool contains = store.contains(roll);
            if (contains)
            {
                cout << "user already exists";
                continue;
                break;
            }
            store.setIn(roll, sObj);
            break;
        }
        case 3:
        {
            cout << "Enter the string" << endl;
            string inp;
            cin >> inp;
            cout << "Enter the index" << endl;
            int ind;
            cin >> ind;
            char ch = obj.checkIndex(inp, ind);
            cout << "The character is " << ch;
            break;
        }
        case 4:
        {
            cout << "Enter the length of an array" << endl;
            int length;
            cin >> length;
            int arr[length];
            for (int i = 0; i < length; i++)
            {
                cin >> arr[i];
            }
            int indVal;
            cout << "Enter the index" << endl;
            cin >> indVal;
            obj.checkArrayIndex(arr, indVal, length);
            break;
        }
        default:
        {
            temp = false;
            break;
        }
        }
    }
    return 0;
}
