//
//  ViewController.swift
//  dynamic-meal-table
//
//  Created by Adalberto Fernandes Junior on 23/10/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import UIKit

class ViewController: UITableViewController {
    
    let meals = [ "eggplant brownie", "zucchini muffin"]

    override func viewDidLoad() {
        super.viewDidLoad()
        print("Did load completed")
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return meals.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let row = indexPath.row
        let meal = meals[ row ]
        let cell = UITableViewCell(style: UITableViewCellStyle.default,
                                   reuseIdentifier: nil)
        cell.textLabel!.text = meal
        return cell
    }
  
}

