//
//  MealTableTableViewController.swift
//  eggplant-brownie
//
//  Created by Adalberto Fernandes Junior on 23/10/16.
//  Copyright © 2016 Adalberto Fernandes Junior. All rights reserved.
//

import UIKit

class MealTableTableViewController: UITableViewController, AddAMealDelegate {

    var meals = [Meal(name: "Eggplant-Brownie", happiness: 4),
                 Meal(name: "Zucchini Muffin", happiness: 4)
    ]
    
    
    func add(meal:Meal) {
        meals.append(meal)
        tableView.reloadData()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "addMeal"{
            let view = segue.destination as! ViewController
            view.delegate = self
        }
    }
    
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return meals.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let row = indexPath.row
        let meal = meals[row]
        let cell = UITableViewCell (style: UITableViewCellStyle.default, reuseIdentifier: nil)
        
        cell.textLabel!.text = meal.name
        
        return cell
    }

}
