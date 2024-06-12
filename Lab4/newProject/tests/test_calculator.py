import unittest
from src.calculator import Calculator

class TestCalculator(unittest.TestCase):

    def setUp(self):
        self.calc = Calculator()

    def test_add(self):
        test_cases = [
            (1, 2, 3),
            (-1, -1, -2),
            (-1, 1, 0)
        ]
        for a, b, expected in test_cases:
            with self.subTest(a=a, b=b, expected=expected):
                self.assertEqual(self.calc.add(a, b), expected)

    def test_subtract(self):
        test_cases = [
            (2, 1, 1),
            (-1, -1, 0),
            (-1, 1, -2)
        ]
        for a, b, expected in test_cases:
            with self.subTest(a=a, b=b, expected=expected):
                self.assertEqual(self.calc.subtract(a, b), expected)

    def test_multiply(self):
        test_cases = [
            (2, 3, 6),
            (-1, -1, 1),
            (-1, 1, -1)
        ]
        for a, b, expected in test_cases:
            with self.subTest(a=a, b=b, expected=expected):
                self.assertEqual(self.calc.multiply(a, b), expected)

    def test_divide(self):
        test_cases = [
            (6, 3, 2),
            (-1, -1, 1),
            (-1, 1, -1)
        ]
        for a, b, expected in test_cases:
            with self.subTest(a=a, b=b, expected=expected):
                self.assertEqual(self.calc.divide(a, b), expected)

        with self.assertRaises(ValueError):
            self.calc.divide(1, 0)
    
    def test_square(self):
        test_cases = [
            (2, 4),
            (-3, 9),
            (0, 0)
        ]
        for a, expected in test_cases:
            with self.subTest(a=a, expected=expected):
                self.assertEqual(self.calc.square(a), expected)

if __name__ == '__main__':
    unittest.main()
