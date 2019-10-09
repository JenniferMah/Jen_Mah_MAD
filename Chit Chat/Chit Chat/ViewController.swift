//
//  ViewController.swift
//  Chit Chat
//
//  Created by Jennifer Mah on 10/5/19.
//  Copyright © 2019 Jennifer Mah. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
// To help get started on the basic layout of a table view I used this resource and apple's documentation. http://www.thomashanning.com/uitableview-tutorial-for-beginners/
    
//arrays for chat topics
    let life = [ "Are you named after anyone?", "What would cause you to leave your current city?", "Who would you like to be for a day?", "What’s your favorite country to visit?", "A book you read in school that positively impacted you?", "Best gift you have ever recieved?" , "How did you meet your best friend?" , "One fact no one knows about you?" , "Most embarrassing memory from your childhood?", "Where did you grow up?", "If you were a crayon, what color would you be?" , "A person you want to habe coffee with and why?", "Best way to decompress?", "What’s your favorite country to visit?" , "When was the last time you cried and why?", "If you were another person would you be friends with you?" , "Have you ever broken any bones?", "Who do you miss the most?" , "What’s your spirit animal?"]
    let deep = [" Are humans better at creation or destruction?" , "What are the chances that we are in a simulation right now?" , " If you had to sum the human species in three words, what would they be?", "What’s the most uplifting thing happening in the world right now?" , "What is a miricle that happens everyday?", "What is a year of life worth?" , "What does the ideal life look like?", " Are emotions necessary for human survival?", "What is holding humans back from working together on a global scale?" , "What does creativity mean to you?" , "Will humans live in space or will they be destroyed first?", "What stops people from understanding themselves?" , "What makes a person evil?", "What event would you rather die than live through?" , "What is the true purpose of art in society?" , "What came first the chicken or the egg?" , "What’s the hardest life choice you’ve made?", "What is holding humans back achieving world peace?", "What are your main goals in life"]
    let short = ["What subject would you teach at school?", "What makes you laugh no matter what?", "What job would you be absolutely terrible at?", "What do most people think about you that is absolutely not true?" , "What class should they teach in high school but don’t?", "What’s one thing you need to have in your fridge at any given time?", "Show me your most bizarre talent", "What’s the best compliment you’ve ever recieved?", "One habit you wish you could break?","Do you have any nicknames?" , "What surprises you the most about people?", "One word to describe your first kiss" , "Who or what is your nemesis?", "what have you have always wanted to try but were to scared to do?", "Do you have any daily rituals?" , "If you could raid one person’s closet who would it be?", "What's the ultimate comfort food?"]
    var savedMessages = [topics]()
    var ClassItemsArray = [topics]()

//Colors
    let deepColor = UIColor(red: 255/255, green:160/255, blue: 94/255, alpha: 1.0)
    let shortColor = UIColor(red: 226/255, green: 131/255, blue: 146/255, alpha: 1.0)
    let lifeColor = UIColor(red: 94/255, green: 175/255, blue: 155/255, alpha: 1.0)
    let savedColor = UIColor(red: 90/255, green: 200/255, blue: 250/255, alpha: 1.0)

    
//Outlets
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var topicControl: UISegmentedControl!
    @IBOutlet weak var SavedTopicsButton: UIButton!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var Back: UIButton!
    
    
//Action
    //action for what happens when the saved items button is pressed
    @IBAction func switchToSaved(_ sender: Any) {
        let total:Int = savedMessages.count
        if total == 0{
            rowsToDisplay = []
        }else{
            rowsToDisplay=[]
            for i in 1 ... total{
                rowsToDisplay.append(savedMessages[i-1].chatLines!)
            }
        }
        titleLabel.text = "Saved Topics"
        topicControl.selectedSegmentIndex = UISegmentedControl.noSegment;
        Back.setTitle("Topics", for: .normal)
        Back.setTitleColor(savedColor,for:.normal)
        SavedTopicsButton.setTitleColor(savedColor,for:.normal)
        topicControl.tintColor = UIColor.black
        tableView.reloadData()
    }
    
    //action for when the back buttons is clicked
    @IBAction func switchToTopics(_ sender: Any) {
        Back.setTitle("", for: .normal)
        titleLabel.text = "Chit Chat"
        topicControl.selectedSegmentIndex = 0;
        rowsToDisplay = life
        topicControl.tintColor = lifeColor
        tableView.reloadData()
    }
    //action for when the segment control is changed
    @IBAction func changeTopic(_ sender: Any) {
        titleLabel.text = "Chit Chat"
        Back.setTitle("", for: .normal)
        if topicControl.selectedSegmentIndex == 0 {
            rowsToDisplay = life
            topicControl.tintColor = lifeColor
        }
        else if topicControl.selectedSegmentIndex == 1{
            rowsToDisplay = deep
            topicControl.tintColor = deepColor

        }
        else if topicControl.selectedSegmentIndex == 2{
            rowsToDisplay = short
            topicControl.tintColor = shortColor

        }
        tableView.reloadData()
    }

    //this is my master array that will show what to display
    //rows to display is created after life array is created
    lazy var rowsToDisplay = life
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //set the data source to this controler
        tableView.dataSource = self
        //UI tableview delegate
        tableView.delegate = self
        
        //Add them to the class array when app intially loads
        for i in 0 ... life.count-1{
            let topic = topics()
            topic.chatLines = life[i]
            topic.color = "lifeColor"
            ClassItemsArray.append(topic)
        }
        for j in 0 ... deep.count-1{
            let topic = topics()
            topic.chatLines = deep[j]
            topic.color = "deepColor"
            ClassItemsArray.append(topic)
        }
        for k in 0 ... short.count-1{
            let topic = topics()
            topic.chatLines = short[k]
            topic.color = "shortColor"
            ClassItemsArray.append(topic)
        }
    }


    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if topicControl.selectedSegmentIndex == 0 || topicControl.selectedSegmentIndex == 1 || topicControl.selectedSegmentIndex == 2{
            let text = rowsToDisplay[indexPath.row]
            for i in 0 ... ClassItemsArray.count-1{
                if ClassItemsArray[i].chatLines == text{
                    savedMessages.append(ClassItemsArray[i])
                }
            }
            
            let alertConroller = UIAlertController(title: "Chit Chat Topic Saved!", message: "You have saved: " + text, preferredStyle: .alert)
            let alertAction = UIAlertAction(title: "OK", style: .cancel, handler: nil)
            alertConroller.addAction(alertAction)
            present(alertConroller,animated:true, completion: nil)
        }
        
    }
    
    //how many sections the table view has (required for table view)
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    //number of rows in the section
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return rowsToDisplay.count
    }
    
    //create the table view cells
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cellReuseIdenifier")!
        let text = rowsToDisplay[indexPath.row]
        cell.textLabel?.text = text
        
        if topicControl.selectedSegmentIndex == 0 {
            cell.textLabel?.textColor = lifeColor
        }
        else if topicControl.selectedSegmentIndex == 1{
           cell.textLabel?.textColor = deepColor
            
        }
        else if topicControl.selectedSegmentIndex == 2{
            cell.textLabel?.textColor = shortColor
        }else{
            if savedMessages[indexPath.row].color == "lifeColor"{
                cell.textLabel?.textColor = lifeColor
            }else if savedMessages[indexPath.row].color == "deepColor"{
                cell.textLabel?.textColor = deepColor
            }else if savedMessages[indexPath.row].color == "shortColor"{
                cell.textLabel?.textColor = shortColor
            }
        }
        return cell
    }
    
    //delete from the saved table view
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete && topicControl.selectedSegmentIndex != 0 && topicControl.selectedSegmentIndex != 1 && topicControl.selectedSegmentIndex != 2 {
            //remove the row from the table view
            print( indexPath.row)
            rowsToDisplay.remove(at: indexPath.row)
            savedMessages.remove(at: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .bottom)
        }
        else{
            let text = rowsToDisplay[indexPath.row]
            let alertConroller = UIAlertController(title: "WARNING", message: "You cannot delete: " + text + " . Only chat lines in saved topics can be deleted.", preferredStyle: .alert)
            let alertAction = UIAlertAction(title: "OK", style: .cancel, handler: nil)
            alertConroller.addAction(alertAction)
            present(alertConroller,animated:true, completion: nil)
        }

    }

    
    
    
}

