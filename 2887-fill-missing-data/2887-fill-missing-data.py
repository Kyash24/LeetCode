import pandas as pd
# DataFrame has a good method for filling null-values - .fillna(), and we'll put inside 0
def fillMissingValues(products: pd.DataFrame) -> pd.DataFrame:
    products['quantity'] = products['quantity'].fillna(0)
    return products