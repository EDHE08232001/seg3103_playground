import unittest
from src.calculator import Calculator

class TestCalculator(unittest.TestCase):

    def setUp(self):
        self.calc = Calculator()

    def _run_test_cases(self, method, test_cases):
        for inputs, expected in test_cases:
            with self.subTest(inputs=inputs, expected=expected):
                self.assertEqual(method(*inputs), expected)

    def test_add(self):
        test_cases = [
            ((1, 2), 3),
            ((-1, -1), -2),
            ((-1, 1), 0)
        ]
        self._run_test_cases(self.calc.add, test_cases)

    def test_subtract(self):
        test_cases = [
            ((2, 1), 1),
            ((-1, -1), 0),
            ((-1, 1), -2)
        ]
        self._run_test_cases(self.calc.subtract, test_cases)

    def test_multiply(self):
        test_cases = [
            ((2, 3), 6),
            ((-1, -1), 1),
            ((-1, 1), -1)
        ]
        self._run_test_cases(self.calc.multiply, test_cases)

    def test_divide(self):
        test_cases = [
            ((6, 3), 2),
            ((-1, -1), 1),
            ((-1, 1), -1)
        ]
        self._run_test_cases(self.calc.divide, test_cases)

        with self.assertRaises(ValueError):
            self.calc.divide(1, 0)
    
    def test_square(self):
        test_cases = [
            (2, 4),
            (-3, 9),
            (0, 0)
        ]
        for input_value, expected in test_cases:
            with self.subTest(input_value=input_value, expected=expected):
                self.assertEqual(self.calc.square(input_value), expected)

if __name__ == '__main__':
    unittest.main()